package com.ecommerce.repository

import com.ecommerce.model.Cartitem
import org.springframework.data.repository.CrudRepository

interface CartItemRepository : CrudRepository<Cartitem, String> {
}