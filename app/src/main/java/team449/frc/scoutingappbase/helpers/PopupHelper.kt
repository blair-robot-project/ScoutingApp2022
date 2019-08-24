package team449.frc.scoutingappbase.helpers

import android.content.Context
import android.view.ContextThemeWrapper
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import team449.frc.scoutingappbase.R
import team449.frc.scoutingappbase.StaticResources


fun info(context: Context, title: String, body: String) {
    AlertDialog.Builder(ContextThemeWrapper(context, R.style.AlertDialogCustom))
        .setTitle(title)
        .setMessage(body)
        .setPositiveButton("Okay", null)
        .show()
        .findViewById<TextView>(android.R.id.message)?.textSize = StaticResources.dialogTextSize
}
