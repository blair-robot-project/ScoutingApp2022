package team449.frc.refereeappbase.helpers

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.NumberPicker
import team449.frc.refereeappbase.main.MainActivity


// Hide keyboard when user clicks outside edit text
// https://stackoverflow.com/questions/4165414/how-to-hide-soft-keyboard-on-android-after-clicking-outside-edittext
fun hideSoftKeyboard(activity: MainActivity?) {
    val inputMethodManager: InputMethodManager? = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputMethodManager?.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
    activity?.updateNavBarVisibility()
}

fun setupKeyboard(view: View, activity: MainActivity?) {
    // Set up touch listener for non-text box views to hide keyboard.
    if (view !is EditText && view !is NumberPicker) view.setOnTouchListener { _, _ -> hideSoftKeyboard(activity); false }

    // If a layout container, iterate over children and seed recursion.
    if (view is ViewGroup) for (i in 0 until view.childCount) setupKeyboard(view.getChildAt(i), activity)
}