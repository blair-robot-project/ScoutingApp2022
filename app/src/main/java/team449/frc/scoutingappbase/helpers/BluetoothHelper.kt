package team449.frc.scoutingappbase.helpers

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothSocket
import android.util.Log
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.lang.Exception
import java.lang.reflect.InvocationTargetException

object BluetoothHelper {

    private const val BUFFER_SIZE = 1024

    private val blueAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private var socket: BluetoothSocket? = null
    private var outputStream: OutputStream? = null
    private var inputStream: InputStream? = null

    private var defaultMaster: String? = null //make this part of settings

    val isConnected: Boolean
        get() = try {
            outputStream!!.write(" ".toByteArray())
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
                    Log.e("BTH.pairedDevices", "Bluetooth is disabled.")
                }
            } else
                Log.e("BTH.pairedDevices", "blueAdapter is null")
            return paired
        }

//    @Throws(IOException::class)
    @JvmOverloads //get rid of the overload to only connect to master set in settings
    fun initializeConnection(targetMasterName: String? = defaultMaster) {
        defaultMaster = targetMasterName
        if (blueAdapter != null) {
            if (blueAdapter.isEnabled) {
                //These are the devices that the tablet is paired with
                try {
                    val device = blueAdapter.bondedDevices.single { it.name == targetMasterName }

                    if (isConnected){
                        Log.i("BTH.initConnection", "Closing old socket ...")
                        socket?.close()
                        socket = null
                        Thread.sleep(500) // Wait for it to disconnect
                    }

                    Log.i("BTH.initConnection", "Attempting to connect to " + device.name)

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
                        if (socket != null) Log.i("BTH.initConnection", "Connected to " + device.name)

                    } catch (e: InvocationTargetException) { // This raps another error from an invoke, I think it won't catch and the wrapped error is what would
                        e.printStackTrace()
                        Log.e("BTH.initConnection", "Error connecting to " + device.name + " (InvocationTargetException)")
                    } catch (e: IllegalArgumentException) { // not seen yet
                        e.printStackTrace()
                        Log.e("BTH.initConnection", "Error connecting to " + device.name + " (IllegalArgumentException)")
                    } catch (e: NoSuchElementException) { // not seen yet
                        e.printStackTrace()
                        Log.e("BTH.initConnection", "Error connecting to " + device.name + " (NoSuchElementException)")
                    } catch (e: IOException) {
                        e.printStackTrace()
                        Log.e("BTH.initConnection", "Error connecting to " + device.name + " (IOException)")
                    }

                } catch (e: NoSuchElementException) {
                    Log.i("BTH.initConnection", "Target master device not found in paired devices")
                } catch (e: IllegalArgumentException) {
                    Log.i("BTH.initConnection", "Multiple instances of target master devices found in paire devices")
                }
            } else {
                Log.e("BTH.initConnection", "Bluetooth is disabled.")
                /*Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBluetooth, 0);*/
            }
        } else {
            Log.e("BTH.initConnection", "blueAdapter is null")
        }
    }

    fun write(str: String): Boolean {
        if (socket != null && socket!!.isConnected) {
            try {
                // Only submit one line at a time so it doesn't exceed the size and get cut off
                for (s in str.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                    outputStream!!.write((s + "\n").toByteArray())
                    outputStream!!.flush()
                }
                return true
            } catch (e: NullPointerException) {
                e.printStackTrace()
                Log.e("BTH.write", "Socket closed while writing (outputStream is null)")
                socket?.close()
            } catch (e: IOException) {
                e.printStackTrace()
                Log.e("BTH.write", "Socket closed while writing (IOException)")
                socket?.close()
            }
        } else {
            Log.e("BTH.write", "Not connected to a device.")
        }
        return false
    }

    fun receive() {
        Log.i("BTH.receive", "Receiving")
        val buffer = ByteArray(BUFFER_SIZE)
        var bytes = 0
        var reading = true

        while (reading) {
            try {
                bytes = inputStream!!.read(buffer, 0, BUFFER_SIZE - 0)
                Log.i("num bytes",bytes.toString())
                Log.i("buffer", String(buffer.copyOfRange(0, bytes)))
            } catch (e: IOException) {
                reading = false
                e.printStackTrace()
                Log.e("BTH.receive", "Socket disconnected while reading (IOE)")
            } catch (e: NullPointerException) {
                reading = false
                e.printStackTrace()
                Log.e("BTH.receive", "Socket disconnected while reading (NPE)")
            }
        }
    }
}
