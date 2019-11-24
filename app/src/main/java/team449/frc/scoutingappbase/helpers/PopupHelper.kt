package team449.frc.scoutingappbase.helpers

import android.content.Context
import android.view.ContextThemeWrapper
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.StaticResources
import team449.frc.scoutingappbase.main.Editor


fun info(context: Context, title: String, body: String) {
    AlertDialog.Builder(ContextThemeWrapper(context, R.style.AlertDialogCustom))
        .setTitle(title)
        .setMessage(body)
        .setPositiveButton("Okay", null)
        .show()
        .findViewById<TextView>(android.R.id.message)?.textSize = StaticResources.dialogTextSize
}

fun editDialog(context: Context, matches: List<Pair<String,Long>>, editor: Editor) {
    AlertDialog.Builder(ContextThemeWrapper(context, R.style.AlertDialogCustom))
        .setTitle("Select a match to edit")
        .setItems(matches.map { it.first }.toTypedArray()) { _,which -> editor.edit(matches[which].second)}
        .create()
        .show()
}