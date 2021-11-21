package com.ecommerce.dto

import javax.persistence.Column
import javax.persistence.Id

class CartDTO() {
    constructor(id: String, totalPrice: Double, status: String) : this()
    var id: String = ""
    var totalPrice: Double = 0.0
    var status: String = ""
}