package team449.frc.refereeappbase.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.NumberPicker
import android.widget.NumberPicker.Formatter
import team449.frc.refereeappbase.R

// From https://stackoverflow.com/a/48219853
class NumberPickerWithXml : NumberPicker {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        processXmlAttributes(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        processXmlAttributes(attrs, defStyleAttr)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        processXmlAttributes(attrs, defStyleAttr, defStyleRes)
    }

    private fun processXmlAttributes(attrs: AttributeSet, defStyleAttr: Int = 0, defStyleRes: Int = 0) {
        val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.NumberPickerWithXml, defStyleAttr, defStyleRes)

        try {
            this.minValue = attributes.getInt(R.styleable.NumberPickerWithXml_minValue, 0)
            this.maxValue = attributes.getInt(R.styleable.NumberPickerWithXml_maxValue, 0)
            val values = attributes.getTextArray(R.styleable.NumberPickerWithXml_android_entries)
            val step = attributes.getInt(R.styleable.NumberPickerWithXml_stepSize, 1)
            val formatter = Formatter {
                if (values == null){
                    (it*step).toString()
                } else {
                    values[it].toString()
                }
            }
            this.setFormatter(formatter)
        } finally {
            attributes.recycle()
        }
    }

}