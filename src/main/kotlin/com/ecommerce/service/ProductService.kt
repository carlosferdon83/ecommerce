package com.ecommerce.service

import com.ecommerce.dto.ProductDTO
import com.ecommerce.model.Product

interface ProductService {
    fun createProduct(product : ProductDTO) : Product;

    fun getAll() : MutableIterable<Product>;

    fun updateProduct(idProduct: String, productDTO: ProductDTO) : Product;

    fun deleteProduct(idProduct: String);
}