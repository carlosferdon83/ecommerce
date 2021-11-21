package com.ecommerce.exceptions

import org.springframework.http.HttpStatus
import java.util.function.Supplier

open class ProductNotFoundException (val statusCode: HttpStatus, val reason: String) : Exception()