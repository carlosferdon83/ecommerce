package com.ecommerce.repository

import com.ecommerce.model.Cart
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository : CrudRepository<Cart,String> {
}