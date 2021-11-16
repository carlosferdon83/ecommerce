package com.ecommerce.service

import com.ecommerce.commons.Utils
import com.ecommerce.dto.ProductDTO
import com.ecommerce.exceptions.ProductNotFoundException
import com.ecommerce.model.Product
import com.ecommerce.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


@Service
class ProductServiceImpl : ProductService {

    @Autowired
    lateinit var productRepository : ProductRepository

    override fun createProduct(productDTO: ProductDTO): Product {
        return productRepository.save(Utils.getProduct(productDTO))
    }

    override fun getAll(): MutableIterable<Product> {
        return productRepository.findAll()
    }

    override fun updateProduct(idProduct: String, productDTO: ProductDTO): Product {
        return if(productRepository.existsById(idProduct)){
            productRepository.save(
                Product(
                    id = idProduct,
                    nombre = productDTO.nombre,
                    precio = productDTO.precio,
                    sku = productDTO.sku,
                    descripcion = productDTO.descripcion,
                    tipo = productDTO.tipo,
                    stock = productDTO.stock
                )
            )
        }else throw ProductNotFoundException(HttpStatus.NOT_FOUND,"No matching product was found")
    }

    override fun deleteProduct(idProduct: String) {
        return if (productRepository.existsById(idProduct)) {
            productRepository.deleteById(idProduct)
        } else throw ProductNotFoundException(HttpStatus.NOT_FOUND, "No matching product was found")
    }
}