package com.ecommerce.exceptions

import org.springframework.http.HttpStatus

class ProductNotFoundException (val statusCode: HttpStatus, val reason: String) : Exception()