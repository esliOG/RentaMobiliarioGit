package com.tuempresa.rentaapp

data class Producto(
    val id: String = "",
    val nombre: String = "",
    val precio: Double = 0.0,
    val descripcion: String = "",
    val imagenUrl: String = "",
    val esPaquete: Boolean = false,
    var cantidadSeleccionada: Int = 0
)