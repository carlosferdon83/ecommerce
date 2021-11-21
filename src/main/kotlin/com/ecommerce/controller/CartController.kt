package com.ecommerce.controller

import com.ecommerce.dto.ApiResponseDTO
import com.ecommerce.dto.CartItemDTO
import com.ecommerce.model.Cart
import com.ecommerce.model.Cartitem
import com.ecommerce.service.CartService
import com.ecommerce.service.CartitemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin("*")
class CartController {

    @Autowired
    lateinit var cartService : CartService

    @Autowired
    lateinit var cartitemService : CartitemService

    @PostMapping("/create")
    fun createCart(@Valid @RequestBody payload : MutableIterable<CartItemDTO>) : ResponseEntity<ApiResponseDTO> {
        var apiResponseDTO = cartService.createCart(payload)
        return ResponseEntity<ApiResponseDTO>(apiResponseDTO, HttpStatus.CREATED)
    }

    @GetMapping("/carts")
    fun getAll() : MutableIterable<Cartitem>{
        return cartitemService.getAll()
    }

}