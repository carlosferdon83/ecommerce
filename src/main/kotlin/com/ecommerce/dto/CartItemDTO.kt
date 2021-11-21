package com.ecommerce.dto

import com.ecommerce.model.Product
import javax.validation.constraints.NotNull

class CartItemDTO ()
{
    constructor(product: Product,
                price: Double,
                quantity: Int,
                cart: String) : this()
    @field:NotNull(message = "Must include product")
    var product: String = ""
    var price: Double = 0.0
    @field:NotNull(message = "Must include quantity")
    var quantity: Int = 0
    var cart: String = ""
}