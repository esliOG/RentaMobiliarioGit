package com.tuempresa.rentaapp.models

import com.tuempresa.rentaapp.models.FurnitureItem
import java.io.Serializable

data class Producto(
    val furniture: FurnitureItem,
    var cantidadSeleccionada: Int = 0
) : Serializable
