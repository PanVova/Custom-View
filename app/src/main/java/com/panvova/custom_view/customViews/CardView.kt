package com.panvova.custom_view.customViews

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.panvova.custom_view.R

class CardView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    private val imageChild: ImageView
        get() = getChildAt(0) as ImageView
    private val textChild: TextView
        get() = getChildAt(1) as TextView

    init {
        val styleAttributes = context.obtainStyledAttributes(attrs, R.styleable.CardView, 0, 0)
        val image = styleAttributes.getDrawable(R.styleable.CardView_cardImage)
        val text = styleAttributes.getString(R.styleable.CardView_cardText)
        styleAttributes.recycle()
        orientation = VERTICAL
        gravity = Gravity.CENTER_VERTICAL
        setBackgroundColor(Color.LTGRAY)
        setInflater()
        setImage(image)
        setTitle(text)
    }

    private fun setInflater() {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.card_view, this, true)
    }

    private fun setImage(image: Drawable?) {
        imageChild.setImageDrawable(image)
    }

    private fun setTitle(titleText: String?) {
        textChild.text = titleText
    }
}