package com.ecommerce.dto

import com.ecommerce.model.Cart
import com.ecommerce.model.Product

class CartItemDTO ()
{
    constructor(product: Product,
                price: Double,
                quantity: Int,
                cart: String) : this()
    var product: String = ""
    var price: Double = 0.0
    var quantity: Int = 0
    var cart: String = ""
}