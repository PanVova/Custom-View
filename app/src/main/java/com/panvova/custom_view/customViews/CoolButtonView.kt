package com.panvova.custom_view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class CoolButtonView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val drawableChild: ImageView?
        get() = if (childCount > 0) getChildAt(0) as ImageView else null
    private val dividerChild: View?
        get() = if (childCount > 1) getChildAt(1) else null
    private val textChild: TextView?
        get() = if (childCount > 1) getChildAt(2) as TextView else null

    init {
        val styleAttributes = context.obtainStyledAttributes(attrs, R.styleable.CoolButton, 0, 0)
        val text = styleAttributes.getString(R.styleable.CoolButton_text)
        val drawable = styleAttributes.getDrawable(R.styleable.CoolButton_drawableStart)

        background = context.getDrawable(R.drawable.round_button)

        styleAttributes.recycle()
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL

        setInflater()
        setImage(drawable)
        setTitle(text)
    }

    private fun setInflater() {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.cool_button, this, true)
    }

    private fun setTitle(titleText: String?) {
        textChild?.text = titleText
    }

    private fun setImage(valueColor: Drawable?) {
        drawableChild?.setImageDrawable(valueColor)
    }
}