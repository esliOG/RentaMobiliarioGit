package com.tuempresa.rentaapp.models

data class FurnitureItem(
    val id: String = "",
    val nombreProducto: String = "",
    val descripcion: String = "",
    val precio: Double = 0.0,
    val totalStock: Int = 0,
    val existencia: Int = 0,
    val imageUrl: String = ""
)
