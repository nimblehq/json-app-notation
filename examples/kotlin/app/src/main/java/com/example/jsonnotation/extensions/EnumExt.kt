package com.example.jsonnotation.extensions

inline fun <reified T : Enum<T>> enumSafeValueOf(value: String) : T? {
    return enumValues<T>().find { it.name == value }
}
