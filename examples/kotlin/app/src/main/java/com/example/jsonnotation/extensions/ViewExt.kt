package com.example.jsonnotation.extensions

import android.view.View
import android.view.ViewGroup

fun <T : View> T.setWidthHeight(width: Int = 0, height: Int = 0): T {
    val newWidth = width.takeIf { it > 0 } ?: ViewGroup.LayoutParams.MATCH_PARENT
    val newHeight = height.takeIf { it > 0 } ?: ViewGroup.LayoutParams.MATCH_PARENT
    layoutParams = ViewGroup.LayoutParams(newWidth, newHeight)
    return this
}
