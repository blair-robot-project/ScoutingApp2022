package team449.frc.scoutingappbase.helpers

import android.content.Context
import android.util.Log
import java.io.*


fun addToFile(filename: String, match: String, ctxt: Context) {
    Log.i("addToFile:filename", filename)
    Log.i("addToFile:match", match)
    val file = File(ctxt.getFilesDir(), filename)
    val fw = FileWriter(file, true)
    val bufferedWriter = BufferedWriter(fw)
    bufferedWriter.write(match + "\n")
    bufferedWriter.close()
    fw.close()
}

fun getFromFile(filename: String, ctxt: Context): String {
    val file = File(ctxt.getFilesDir(), filename)
    try {
        val br = BufferedReader(FileReader(file))
        var st: String
        val all = StringBuilder()
        while ((st = br.readLine()) != null)
            all.append(st).append("\n")
        Log.i("getfromfile", all.toString())
        return all.toString()
    } catch (e: IOException) {
        e.printStackTrace()
        return ""
    }
}