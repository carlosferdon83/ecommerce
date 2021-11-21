package com.ecommerce.dto

import com.ecommerce.model.Cart
import com.ecommerce.model.Cartitem
import com.ecommerce.model.Product
import org.springframework.http.HttpStatus

class ApiResponseDTO(){

    constructor(status: String,
                details: String) : this()

    var status : String = ""
    var details : String = ""

}