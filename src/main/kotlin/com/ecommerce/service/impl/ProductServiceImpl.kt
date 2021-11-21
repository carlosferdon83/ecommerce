package com.ecommerce.service.impl

import com.ecommerce.commons.Utils
import com.ecommerce.dto.ProductDTO
import com.ecommerce.exceptions.ProductNotFoundException
import com.ecommerce.model.Product
import com.ecommerce.repository.ProductRepository
import com.ecommerce.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


@Service
open class ProductServiceImpl : ProductService {

    @Autowired
    lateinit var productRepository : ProductRepository

    override fun createProduct(productDTO: ProductDTO): Product {
        if(productDTO.type == "PROMOCION"){
            productDTO.price = productDTO.price / 2
        }
        return productRepository.save(Utils.getProduct(productDTO))
    }

    override fun getAll(): MutableIterable<Product> {
        return productRepository.findAll()
    }

    override fun updateProduct(idProduct: String, productDTO: ProductDTO): Product {
        val product = Utils.getProduct(productDTO)
        return if(productRepository.existsById(idProduct)){
            productRepository.save(product)
        }else throw ProductNotFoundException(HttpStatus.NOT_FOUND,"No matching product was found")
    }

    override fun deleteProduct(idProduct: String) {
        return if (productRepository.existsById(idProduct)) {
            productRepository.deleteById(idProduct)
        } else throw ProductNotFoundException(HttpStatus.NOT_FOUND, "No matching product was found")
    }
}