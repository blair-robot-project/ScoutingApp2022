package team449.frc.scoutingappbase.managers

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothSocket
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.lang.reflect.InvocationTargetException

object BluetoothManager {

    private const val BUFFER_SIZE = 1024

    private val blueAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private var socket: BluetoothSocket? = null
    private var outputStream: OutputStream? = null
    private var inputStream: InputStream? = null

    private val connectionTest: ByteArray = ByteArray(0) {0}

    val isConnected: Boolean
        get() = try {
            outputStream!!.write(connectionTest)
            true
        } catch (e: Exception) {
            false
        }

    //These are the devices that the tablet is paired with
    val pairedDevices: List<String>
        get() {
            val paired = ArrayList<String>()
            if (blueAdapter != null) {
                if (blueAdapter.isEnabled) {
                    for (device in blueAdapter.bondedDevices) {
                        paired.add(device.name)
                    }
                } else {
                    Log.e("BtM.pairedDevices", "Bluetooth is disabled.")
                }
            } else
                Log.e("BtM.pairedDevices", "blueAdapter is null")
            return paired
        }

    fun connect(targetMasterName: String): Boolean {
        if (blueAdapter != null) {
            if (blueAdapter.isEnabled) {
                //These are the devices that the tablet is paired with
                try {
                    val device = blueAdapter.bondedDevices.single { it.name == targetMasterName }

                    if (isConnected){
                        Log.i("BtM.initConnection", "Closing old socket ...")
                        socket?.close()
                        socket = null
                        Thread.sleep(500) // Wait for it to disconnect
                    }

                    Log.i("BtM.initConnection", "Attempting to connect to " + device.name)

                    //val uuids = device.uuids
                    //device.createRfcommSocketToServiceRecord(uuids[0].uuid)
                    //Can't use this because it gives port of -1
                    //https://stackoverflow.com/questions/18657427/ioexception-read-failed-socket-might-closed-bluetooth-on-android-4-3
                    //See second answer
                    try {
                        socket = device.javaClass.getMethod("createRfcommSocket", Integer::class.javaPrimitiveType).invoke(
                            device,
                            1
                        ) as BluetoothSocket
                        socket?.connect()
                        outputStream = socket?.outputStream
                        inputStream = socket?.inputStream
                        if (socket != null) Log.i("BtM.initConnection", "Connected to " + device.name)

                        GlobalScope.launch { receive() }
                        return true

                    } catch (e: InvocationTargetException) { // This raps another error from an invoke, I think it won't catch and the wrapped error is what would
                        e.printStackTrace()
                        Log.e("BtM.initConnection", "Error connecting to " + device.name + " (InvocationTargetException)")
                    } catch (e: IllegalArgumentException) { // not seen yet
                        e.printStackTrace()
                        Log.e("BtM.initConnection", "Error connecting to " + device.name + " (IllegalArgumentException)")
                    } catch (e: NoSuchElementException) { // not seen yet
                        e.printStackTrace()
                        Log.e("BtM.initConnection", "Error connecting to " + device.name + " (NoSuchElementException)")
                    } catch (e: IOException) {
                        Log.e("BtM.initConnection", "Error connecting to " + device.name + " (IOException)")
                    }
                } catch (e: NoSuchElementException) {
                    Log.i("BtM.initConnection", "Target master device not found in paired devices")
                } catch (e: IllegalArgumentException) {
                    Log.i("BtM.initConnection", "Multiple instances of target master devices found in paire devices")
                }
            } else {
                Log.e("BtM.initConnection", "Bluetooth is disabled.")
                /*Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBluetooth, 0);*/
            }
        } else {
            Log.e("BtM.initConnection", "blueAdapter is null")
        }
        return false
    }

    fun write(str: String): Boolean {
        if (socket != null && socket!!.isConnected) {
            try {
                outputStream!!.write(str.toByteArray())
                outputStream!!.flush()
                return true
            } catch (e: NullPointerException) {
                Log.e("BtM.write", "Socket closed while writing (outputStream is null)")
                socket?.close()
            } catch (e: IOException) {
                Log.e("BtM.write", "Socket closed while writing (IOException)")
                socket?.close()
            }
        } else {
            Log.e("BtM.write", "Not connected to a device.")
        }
        return false
    }

    fun receive() {
        if (isConnected) {
            Log.i("BtM.receive", "Receiving")
            val buffer = ByteArray(BUFFER_SIZE)
            var bytes: Int
            var reading = true
            while (reading) {
                try {
                    bytes = inputStream!!.read(buffer, 0, BUFFER_SIZE - 0)
                    MessageHandler.handleRawMessage(String(buffer.copyOfRange(0, bytes)))
                } catch (e: IOException) {
                    reading = false
                    Log.e("BtM.receive", "Socket disconnected while listening (IOE)")
                } catch (e: NullPointerException) {
                    reading = false
                    Log.e("BtM.receive", "Socket disconnected while listening (NPE)")
                }
            }
        } else {
            Log.e("BtM.receive", "Bluetooth not connected")
        }
    }
}
