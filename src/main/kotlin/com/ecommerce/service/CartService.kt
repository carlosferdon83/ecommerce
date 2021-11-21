package com.ecommerce.service

import com.ecommerce.dto.ApiResponseDTO
import com.ecommerce.dto.CartItemDTO
import com.ecommerce.model.Cart

interface CartService {
    fun createCart(cartItemDTO : MutableIterable<CartItemDTO>) : ApiResponseDTO

    fun getAllCarts() : MutableIterable<Cart>;
}