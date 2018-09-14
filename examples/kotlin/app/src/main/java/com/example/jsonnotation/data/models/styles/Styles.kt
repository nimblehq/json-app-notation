package com.example.jsonnotation.data.models.styles

data class Style(val targetClass: String, val targetElement: String, val data: StyleDefault)

interface StyleDefault {

    val marginLeft: Double
    val marginTop: Double
    val marginRight: Double
    val marginBottom: Double

}