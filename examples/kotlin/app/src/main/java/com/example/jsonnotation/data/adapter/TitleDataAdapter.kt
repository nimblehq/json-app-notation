package com.example.jsonnotation.data.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.example.jsonnotation.data.models.elements.ButtonElement
import com.example.jsonnotation.data.models.elements.Container
import com.example.jsonnotation.data.models.elements.Element
import com.example.jsonnotation.data.models.elements.ImageButtonElement
import com.example.jsonnotation.data.models.elements.ImageElement
import com.example.jsonnotation.data.models.elements.ImageTitleElement
import com.example.jsonnotation.data.models.elements.LabelElement
import com.example.jsonnotation.data.models.elements.TextTitleElement
import com.example.jsonnotation.data.models.elements.UiType
import com.example.jsonnotation.extensions.deserialize
import com.example.jsonnotation.extensions.enumSafeValueOf
import java.lang.reflect.Type

class UIElementAdapter : JsonDeserializer<Element> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Element {
        val jsonObject = json.asJsonObject
        val jsonType = jsonObject.get("type").asString
        val type = enumSafeValueOf<UiType>(jsonType)
            ?: throw IllegalArgumentException("Cannot find type of $jsonType")
        return when (type) {
            UiType.textTitleBar -> context.deserialize<TextTitleElement>(jsonObject)
            UiType.imageTitleBar -> context.deserialize<ImageTitleElement>(jsonObject)
            UiType.container -> context.deserialize<Container>(jsonObject)
            UiType.textButton -> context.deserialize<ButtonElement>(jsonObject)
            UiType.image -> context.deserialize<ImageElement>(jsonObject)
            UiType.imageButton -> context.deserialize<ImageButtonElement>(jsonObject)
            UiType.label -> context.deserialize<LabelElement>(jsonObject)
        }
    }
}
