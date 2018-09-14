package com.example.jsonnotation.data.models.styles

data class LabelStyle(
    val numberOfLines: Int,
    val textColor: String,
    val textSize: Int,
    override val marginLeft: Double,
    override val marginTop: Double,
    override val marginRight: Double,
    override val marginBottom: Double
) : StyleDefault