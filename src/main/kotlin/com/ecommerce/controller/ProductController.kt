package com.ecommerce.controller

import com.ecommerce.dto.ProductDTO
import com.ecommerce.model.Product
import com.ecommerce.service.ProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin("*")
@Api(description = "Rest API for product operations")
class ProductController {

    @Autowired
    lateinit var productService : ProductService

    @GetMapping("/products")
    @ApiOperation(value = "Display all products", response = Product::class)
    fun getAllProductos() : MutableIterable<Product>{
        return productService.getAll()
    }

    @PostMapping("/products")
    @ApiOperation(value = "Create a new product", response = Product::class)
    fun createProduct(@Valid @RequestBody payload : ProductDTO) : ResponseEntity<Product> {
        var product = productService.createProduct(payload)
        return ResponseEntity<Product>(product, HttpStatus.OK)
    }

    @PutMapping("/products/{id}")
    @ApiOperation(value = "Update a product", response = Product::class)
    fun updateProduct(@PathVariable("id") id : String, @Valid @RequestBody payload: ProductDTO) : ResponseEntity<Product>{
        var product = productService.updateProduct(id,payload)
        return ResponseEntity<Product>(product, HttpStatus.OK)
    }

    @DeleteMapping("/products/{id}")
    @ApiOperation(value = "Delete a product", response = Product::class)
    fun deleteProduct(@PathVariable("id") id : String) : ResponseEntity<String> {
        productService.deleteProduct(id)
        return ResponseEntity<String>("The product has been deleted",HttpStatus.OK)
    }
}