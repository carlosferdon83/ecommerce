package com.ecommerce.service

import com.ecommerce.model.Cartitem

interface CartitemService {
    fun getAll() : MutableIterable<Cartitem>
}