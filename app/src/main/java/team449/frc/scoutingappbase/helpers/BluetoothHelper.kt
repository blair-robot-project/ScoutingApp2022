package team449.frc.scoutingappbase.helpers

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothSocket
import android.util.Log
import java.io.IOException
import java.io.OutputStream
import java.util.*

class BluetoothHelper {

    private val blueAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private var socket: BluetoothSocket? = null
    private var outputStream: OutputStream? = null

    private var defaultMaster: String? = null //make this part of settings

    val isConnected: Boolean
        get() = write(" ")

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
    @JvmOverloads //get rid of the overload to only connect to master
    fun initializeConnection(targetMasterName: String? = defaultMaster) {
        defaultMaster = targetMasterName
        if (blueAdapter != null) {
            if (blueAdapter.isEnabled) {
                //These are the devices that the tablet is paired with
                try {
                    val device = blueAdapter.bondedDevices.single { it.name == targetMasterName }

                    Log.i("BTH.initConnection", "Attempting to connect to " + device.name)
                    val uuids = device.uuids

                    //BluetoothSocket socket = device.createRfcommSocketToServiceRecord(uuids[0].getUuid());
                    //Can't use this because it gives port of -1
                    //https://stackoverflow.com/questions/18657427/ioexception-read-failed-socket-might-closed-bluetooth-on-android-4-3
                    //See second answer
                    socket = try {
                        device.createRfcommSocketToServiceRecord(uuids[0].uuid)
                    } catch (e: IOException) {
                        device.javaClass.getMethod("createRfcommSocket", Integer::class.javaPrimitiveType).invoke(device, 1) as BluetoothSocket
                    }
                    //Errors that might come up (based on old app): IllegalAccessException, InvocationTargetException, NoSuchMethodException

                    socket?.connect()
                    outputStream = socket?.outputStream
                    if (socket != null) Log.i("BTH.initConnection", "Connected to " + device.name)

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
                Log.e("BTH.write", "outputStream is null")
            } catch (e: IOException) {
                e.printStackTrace()
                Log.e("BTH.write", "IOExecption, socket is probably closed on the other end")
            }
        } else {
            Log.e("BTH.write", "Not connected to a device.")
        }
        return false
    }
}
