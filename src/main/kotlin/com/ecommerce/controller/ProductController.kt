package com.ecommerce.controller

import com.ecommerce.dto.ProductDTO
import com.ecommerce.model.Product
import com.ecommerce.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin("*")
class ProductController {

    @Autowired
    lateinit var productService : ProductService

    @GetMapping("/products")
    fun getAllProductos() : MutableIterable<Product>{
        return productService.getAll()
    }

    @PostMapping("/products")
    fun createProduct(@Valid @RequestBody payload : ProductDTO) : ResponseEntity<Product> {
        var product = productService.createProduct(payload)
        return ResponseEntity<Product>(product, HttpStatus.OK)
    }

    @PutMapping("/products/{id}")
    fun updateProduct(@PathVariable("id") id : String, @Valid @RequestBody payload: ProductDTO) : ResponseEntity<Product>{
        var product = productService.updateProduct(id,payload)
        return ResponseEntity<Product>(product, HttpStatus.OK)
    }

    @DeleteMapping("/products/{id}")
    fun deleteProduct(@PathVariable("id") id : String) : ResponseEntity<String> {
        productService.deleteProduct(id)
        return ResponseEntity<String>("The product has been deleted",HttpStatus.OK)
    }
}