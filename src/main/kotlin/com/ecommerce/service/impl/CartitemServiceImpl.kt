package com.ecommerce.service.impl

import com.ecommerce.model.Cartitem
import com.ecommerce.repository.CartItemRepository
import com.ecommerce.service.CartitemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CartitemServiceImpl : CartitemService {

    @Autowired
    lateinit var cartItemRepository: CartItemRepository

    override fun getAll(): MutableIterable<Cartitem> {
        return cartItemRepository.findAll()
    }

}