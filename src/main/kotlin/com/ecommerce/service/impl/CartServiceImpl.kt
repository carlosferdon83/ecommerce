package com.ecommerce.service.impl

import com.ecommerce.commons.Utils
import com.ecommerce.dto.CartItemDTO
import com.ecommerce.enums.CartStatus
import com.ecommerce.exceptions.ProductNotFoundException
import com.ecommerce.model.Cart
import com.ecommerce.model.Cartitem
import com.ecommerce.model.Product
import com.ecommerce.repository.CartItemRepository
import com.ecommerce.repository.CartRepository
import com.ecommerce.repository.ProductRepository
import com.ecommerce.service.CartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.*

@Service
class CartServiceImpl : CartService {

    @Autowired
    lateinit var cartRepository: CartRepository

    @Autowired
    lateinit var cartItemRepository: CartItemRepository

    @Autowired
    lateinit var productRepository: ProductRepository

    override fun createCart(cartItemDTO: MutableIterable<CartItemDTO>): Cart {

        var cart : Cart = Utils.getCart()
        var savedCart: Cart = cartRepository.save(cart)
        cartItemDTO.iterator().forEach {
            var product : Product = productRepository.findById(it.product.toString()).orElseThrow{ throw ProductNotFoundException(HttpStatus.NOT_FOUND, "No matching product was found")}
            var item: Cartitem = Utils.getCartItem(it,savedCart, product)
            var cartItem : Cartitem = cartItemRepository.save(item)
        }
        return cart
    }

    override fun getAllCarts(): MutableIterable<Cart> {
        return cartRepository.findAll()
    }

}


