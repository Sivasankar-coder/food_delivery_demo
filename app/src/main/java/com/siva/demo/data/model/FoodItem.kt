package com.siva.demo.data.model

data class FoodItem(
    val id: Int,
    val name: String,
    val price: Double,
    val image: Any,
    val description: String = ""
)
