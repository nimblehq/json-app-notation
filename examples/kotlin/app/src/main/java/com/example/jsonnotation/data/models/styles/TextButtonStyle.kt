package com.example.jsonnotation.data.models.styles

data class TextButtonStyle(
    val textColor: String,
    val textSize: Int,
    override val marginLeft: Double,
    override val marginTop: Double,
    override val marginRight: Double,
    override val marginBottom: Double
) : StyleDefault