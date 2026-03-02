package com.tuempresa.rentaapp.models

data class User(
    val id: String = "",
    val nombreUsuario: String = "",
    val email: String = "",
    val telefono: String = "",
    val role: Role = Role.CLIENTE
)

enum class Role {
    CLIENTE, ADMINISTRADOR
}
