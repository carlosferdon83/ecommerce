package com.ecommerce.dto

data class ProductDTO(
    val name: String,
    val sku: String,
    val price: Double,
    val description: String,
    val type: String,
    val stock: Long
)
