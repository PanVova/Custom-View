package com.panvova.custom_view.customViews

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.panvova.custom_view.R

class ColorOptionsView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    init {
        val styleAttributes = context.obtainStyledAttributes(attrs, R.styleable.Options, 0, 0)
        val titleText = styleAttributes.getString(R.styleable.Options_titleText)
        val valueColor = styleAttributes.getColor(
            R.styleable.Options_valueColor,
            Color.YELLOW
        )
        styleAttributes.recycle()
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setInflater()
        setTitle(titleText)
        setValueColor(valueColor)
    }

    private fun setInflater() {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_color_options, this, true)
    }

    private fun setTitle(titleText: String?) {
        val title = getChildAt(0) as TextView
        title.text = titleText
    }

    private fun setValueColor(valueColor: Int) {
        val value = getChildAt(1) as View
        value.setBackgroundColor(valueColor)
    }
}