package com.example.jsonnotation.extensions

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken

inline fun <reified T> JsonDeserializationContext.deserialize(data: JsonElement) : T {
    return deserialize(data, object : TypeToken<T>() {}.type)
}
