package com.ecommerce.commons

import com.ecommerce.dto.ProductDTO
import com.ecommerce.model.Product
import java.util.*

class Utils {

    companion object Products{
        fun getProduct(productDTO : ProductDTO) : Product{
            val uuid = UUID.randomUUID()
            val product = Product()
            product.id = uuid.toString()
            product.nombre = productDTO.nombre
            product.precio = productDTO.precio
            product.sku = productDTO.sku
            product.descripcion = productDTO.descripcion
            product.tipo = productDTO.tipo
            product.stock = productDTO.stock
            return product
        }
    }


}