package com.example.jsonnotation.data.models.styles

data class ImageStyle(
    val width: Int,
    val height: Int,
    val fillingMode: FillingMode,
    override val marginLeft: Double,
    override val marginTop: Double,
    override val marginRight: Double,
    override val marginBottom: Double
): StyleDefault
