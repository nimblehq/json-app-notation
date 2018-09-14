package com.example.jsonnotation.data.uibuilder

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import com.google.gson.Gson
import com.example.jsonnotation.MainActivity
import com.example.jsonnotation.R
import com.example.jsonnotation.data.models.elements.ButtonElement
import com.example.jsonnotation.data.models.elements.Container
import com.example.jsonnotation.data.models.elements.Element
import com.example.jsonnotation.data.models.elements.ImageButtonElement
import com.example.jsonnotation.data.models.elements.ImageElement
import com.example.jsonnotation.data.models.elements.ImageTitleElement
import com.example.jsonnotation.data.models.elements.LabelElement
import com.example.jsonnotation.data.models.elements.Navigator
import com.example.jsonnotation.data.models.elements.TextTitleElement
import com.example.jsonnotation.data.models.elements.UiAction
import com.example.jsonnotation.extensions.loadImage
import com.example.jsonnotation.extensions.setWidthHeight

class UiBuilder(private val gson: Gson) {

    fun build(context: Context, json: String, initialScreenId: String? = null): ViewGroup {
        val navigator = gson.fromJson(json, Navigator::class.java)
        val selectedScreenId = initialScreenId?.takeIf { it.isNotBlank() }
            ?: navigator.data.initialScreenId
        val selectedScreen = navigator.data.screens.find { it.data.elementId == selectedScreenId }
            ?: throw IllegalArgumentException("Could not find screen id $selectedScreenId")

        val toolbar: View? = selectedScreen.data.title?.let { buildUiElement(context, it) }
        val body: List<View> = selectedScreen.data.body.data.elements.map { buildUiElement(context, it) }

        val bodyContainer = LinearLayout(context).apply {
            gravity = Gravity.CENTER
            orientation = LinearLayout.VERTICAL
            body.forEach { addView(it) }
        }

        val scrollingContainer = NestedScrollView(context).apply {
            scrollBarStyle = NestedScrollView.SCROLLBARS_OUTSIDE_OVERLAY
            addView(bodyContainer)
        }

        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            toolbar?.let { toolbar -> addView(toolbar) }
            addView(scrollingContainer)
        }
    }

    private fun buildUiElement(context: Context, element: Element): View {
        return when (element) {
            is TextTitleElement -> createToolbar(context, element.data.text)
            is ImageTitleElement -> {
                createToolbar(context, "ImageTitle").apply {
                    addView(ImageView(context).apply { loadImage(element.data.image.data.source) })
                }
            }
            is Container -> LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                element.data.elements
                    .map { buildUiElement(context, it) }
                    .forEach { addView(it) }
            }
            is ImageElement -> ImageView(context).setWidthHeight(width = MATCH_PARENT, height = 720).apply {
                this.scaleType = ImageView.ScaleType.CENTER_INSIDE
                this.loadImage(element.data.source)
            }
            is ImageButtonElement -> ImageButton(context).setWidthHeight(120, 120).apply { loadImage(element.data.source) }
            is ButtonElement -> Button(context).apply {
                text = element.data.text
                element.data.action?.let { action ->
                    when (action.type) {
                        UiAction.push -> setOnClickListener { MainActivity.start(context, action.destination) }
                    }
                }
            }
            is LabelElement -> TextView(context).apply { text = element.data.text }
            else -> TODO()
        }
    }

}

private fun createToolbar(context: Context, title: String = ""): Toolbar = Toolbar(context).apply {
    this.title = title
    this.setBackgroundColor(ContextCompat.getColor(this.context, R.color.colorPrimary))
    this.setTitleTextColor(Color.WHITE)
}
