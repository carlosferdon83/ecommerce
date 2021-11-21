package com.ecommerce.dto

import com.ecommerce.model.Product
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ProductDTO(){

    constructor(
        name: String,
        sku: Double,
        price: String,
        description: String,
        type: String,
        stock: String) : this()
    @field:NotEmpty(message = "Must include name")
    @field:NotNull(message = "Must include name")
    var name: String = ""
    @field:NotEmpty(message = "Must include sku")
    @field:NotNull(message = "Must include sku")
    var sku: String = ""
    var price: Double = 0.0
    @field:NotEmpty(message = "Must include description")
    @field:NotNull(message = "Must include description")
    var description: String = ""
    @field:NotEmpty(message = "Must include type")
    @field:NotNull(message = "Must include type")
    var type: String = ""
    var stock: Long = 0
}


