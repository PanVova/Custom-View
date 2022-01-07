package com.panvova.custom_view.customViews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class EmojiView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val lineX1 = 300.0F
    private val lineY1 = 500.0F
    private val lineX2 = 800.0F
    private val lineY2 = 300.0F
    private val textXOffset = 0
    private val textYOffset = 400
    private val radius = 100.0F
    private val paintShape = Paint()

    private var halfWidth: Float = (measuredWidth / 2).toFloat()
    private var halfHeight: Float = (measuredHeight / 2).toFloat()

    init {
        paintShape.apply {
            style = Paint.Style.FILL
            color = Color.BLACK
            textSize = 60F
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val someText = "Some Text"
        halfWidth = (measuredWidth / 2).toFloat()
        halfHeight = (measuredHeight / 2).toFloat()

        canvas?.drawLine(lineX1, lineY1, lineX2, lineY2, paintShape)
        canvas?.drawLine(lineX1, lineY2, lineX2, lineY1, paintShape)

        canvas?.drawCircle((lineX1 + lineX2) / 2, (lineY1 + lineY2) / 2, radius, paintShape)

        val widthText = paintShape.measureText(someText)
        canvas?.drawText(
            someText,
            halfWidth - widthText / 2,
            halfHeight,
            paintShape
        )

        canvas?.drawText(
            "This is Emoji",
            (measuredWidth / 3).toFloat(),
            textYOffset + halfHeight,
            paintShape
        )
    }
}