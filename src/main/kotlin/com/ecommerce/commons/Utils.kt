package com.ecommerce.commons

import com.ecommerce.dto.ApiResponseDTO
import com.ecommerce.dto.CartItemDTO
import com.ecommerce.dto.ProductDTO
import com.ecommerce.enums.CartStatus
import com.ecommerce.model.Cart
import com.ecommerce.model.Cartitem
import com.ecommerce.model.Product
import java.util.UUID;

open class Utils {

    companion object Process{
        fun getProduct(productDTO : ProductDTO) : Product {
            val product = Product()
            product.id = getUUID()
            product.name = productDTO.name
            product.price = productDTO.price
            product.sku = productDTO.sku
            product.description = productDTO.description
            product.type = productDTO.type
            product.stock = productDTO.stock
            return product
        }

        fun getCart() : Cart {
            val cart = Cart()
            cart.id = getUUID()
            cart.totalPrice = 0.0
            cart.status = CartStatus.CREATED.status
            return cart
        }

        fun getCartItem(cartItemDTO: CartItemDTO, cart : Cart, product: Product) : Cartitem {
            val cartitem = Cartitem()
            cartitem.product= product
            cartitem.quantity = cartItemDTO.quantity
            cartitem.cart = cart
            cartitem.id = getUUID()
            cartitem.price = cartitem.quantity * product.price
            return cartitem
        }

        fun getUUID() : String{
            val uuid = UUID.randomUUID()
            return uuid.toString()
        }

        fun getResponse(status : String, detail : String) : ApiResponseDTO{
            val apiResponseDTO = ApiResponseDTO()
            apiResponseDTO.status = status
            apiResponseDTO.details = detail
            return apiResponseDTO
        }
    }


}