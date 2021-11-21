package com.ecommerce.service.impl

import com.ecommerce.commons.Utils
import com.ecommerce.dto.ApiResponseDTO
import com.ecommerce.dto.CartItemDTO
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

@Service
class CartServiceImpl : CartService {

    @Autowired
    lateinit var cartRepository: CartRepository

    @Autowired
    lateinit var cartItemRepository: CartItemRepository

    @Autowired
    lateinit var productRepository: ProductRepository

    override fun createCart(cartItemDTO: MutableIterable<CartItemDTO>): ApiResponseDTO {
        var total : Double = 0.0
        var cart : Cart = Utils.getCart()
        var savedCart: Cart = cartRepository.save(cart)
        cartItemDTO.iterator().forEach {
            var product : Product = productRepository.findById(it.product.toString()).orElseThrow{ throw ProductNotFoundException(HttpStatus.NOT_FOUND, "No matching product was found")}
            if( product.stock >= it.quantity){
                var item: Cartitem = Utils.getCartItem(it,savedCart, product)
                total = total.plus(item.price)
                var cartItem : Cartitem = cartItemRepository.save(item)
            }else return Utils.getResponse("Error","There is not enough inventory for the product "+product.name)
        }
        var updatedCart : Cart = updateCartInfo(savedCart, total)
        return Utils.getResponse("Success","Cart saved [ID] "+updatedCart.id)
    }

    override fun getAllCarts(): MutableIterable<Cart> {
        return cartRepository.findAll()
    }

    fun updateCartInfo(cart: Cart, total : Double) : Cart {
        cart.totalPrice = total
        return cartRepository.save(cart)
    }

}


