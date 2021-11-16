package com.ecommerce.repository

import com.ecommerce.model.Carrito
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CarritoRepository : CrudRepository<Carrito,String> {
}