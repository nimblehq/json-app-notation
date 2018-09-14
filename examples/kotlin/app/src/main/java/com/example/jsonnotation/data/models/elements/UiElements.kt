package com.example.jsonnotation.data.models.elements

// Root

data class Navigator(val type: String, val data: NavigatorData)
data class NavigatorData(val elementId: String, val initialScreenId: String, val screens: List<Screen>)

data class Screen(val type: String, val data: ScreenData)
data class ScreenData(val elementId: String, val title: Element?, val body: Container)

// Title UI Components

data class TextTitleElement(val data: TextTitleElementData, val type: UiType) : Element
data class TextTitleElementData(val elementId: String, val text: String, override val classes: List<String>?) : ElementData

data class ImageTitleElement(val data: ImageTitleElementData, val type: UiType) : Element
data class ImageTitleElementData(val elementId: String, val image: ImageElement, override val classes: List<String>?) : ElementData

// Body UI Components

data class Container(val type: UiType, val data: ContainerData) : Element
data class ContainerData(val elementId: String, val elements: List<Element>, override val classes: List<String>?) : ElementData

data class ButtonElement(val data: ButtonElementData, val type: UiType) : Element
data class ButtonElementData(val elementId: String, val text: String, val action: ButtonAction?, override val classes: List<String>?) : ElementData

data class ImageElement(val data: ImageElementData, val type: UiType) : Element
data class ImageElementData(val elementId: String, val source: String, override val classes: List<String>?) : ElementData

data class ImageButtonElement(val data: ImageButtonElementData, val type: UiType) : Element
data class ImageButtonElementData(val elementId: String, val source: String, override val classes: List<String>?) : ElementData

data class LabelElement(val data: LabelElementData, val type: UiType) : Element
data class LabelElementData(val elementId: String, val text: String, override val classes: List<String>?) : ElementData

// Ui Action

data class ButtonAction(val type: UiAction, val destination: String)

