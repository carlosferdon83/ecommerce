package com.ecommerce.dto

data class ProductDTO(
    val nombre: String,
    val sku: String,
    val precio: Double,
    val descripcion: String,
    val tipo: String,
    val stock: Int
)
