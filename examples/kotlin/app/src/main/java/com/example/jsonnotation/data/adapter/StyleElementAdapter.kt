package com.example.jsonnotation.data.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.example.jsonnotation.data.models.styles.ContainerStyle
import com.example.jsonnotation.data.models.styles.ImageButtonStyle
import com.example.jsonnotation.data.models.styles.ImageStyle
import com.example.jsonnotation.data.models.styles.LabelStyle
import com.example.jsonnotation.data.models.styles.Style
import com.example.jsonnotation.data.models.styles.TargetElements
import com.example.jsonnotation.data.models.styles.TextButtonStyle
import com.example.jsonnotation.extensions.deserialize
import com.example.jsonnotation.extensions.enumSafeValueOf
import java.lang.reflect.Type

class StyleElementAdapter : JsonDeserializer<Style> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Style {
        val jsonObject = json.asJsonObject
        val jsonTargetClass = jsonObject.get("targetClass").asString
        val jsonTargetElement = jsonObject.get("targetElement").asString
        val targetElement = enumSafeValueOf<TargetElements>(jsonTargetElement)
            ?: throw IllegalArgumentException("Cannot find target element type of $jsonTargetElement")
        val data = jsonObject.get("data")
        val styleData = when (targetElement) {
            TargetElements.container -> context.deserialize<ContainerStyle>(data)
            TargetElements.image -> context.deserialize<ImageStyle>(data)
            TargetElements.imageButton -> context.deserialize<ImageButtonStyle>(data)
            TargetElements.label -> context.deserialize<LabelStyle>(data)
            TargetElements.textButton -> context.deserialize<TextButtonStyle>(data)
        }
        return Style(jsonTargetClass, jsonTargetElement, styleData)
    }

}
