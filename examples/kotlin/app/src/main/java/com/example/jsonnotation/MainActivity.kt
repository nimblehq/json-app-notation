package com.example.jsonnotation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.example.jsonnotation.data.adapter.StyleElementAdapter
import com.example.jsonnotation.data.adapter.UIElementAdapter
import com.example.jsonnotation.data.models.elements.Element
import com.example.jsonnotation.data.models.styles.Style
import com.example.jsonnotation.data.uibuilder.UiBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gson = GsonBuilder()
            .registerTypeAdapter(Element::class.java, UIElementAdapter())
            .registerTypeAdapter(Style::class.java, StyleElementAdapter())
            .create()
        val uiBuilder = UiBuilder(gson)

        val json = assets.open("shot.json").bufferedReader().use { it.readText() }
        val initialScreenId: String? = intent.getStringExtra(EXTRA_INITIAL_SCREEN_ID)
        val content = uiBuilder.build(this, json, initialScreenId)
        setContentView(content)
    }

    companion object {

        private const val EXTRA_INITIAL_SCREEN_ID = "EXTRA_INITIAL_SCREEN_ID"

        fun start(context: Context, initialScreenId: String = "") {
            val intent = Intent(context, MainActivity::class.java).apply {
                putExtra(EXTRA_INITIAL_SCREEN_ID, initialScreenId)
            }
            context.startActivity(intent)
        }

    }

}
