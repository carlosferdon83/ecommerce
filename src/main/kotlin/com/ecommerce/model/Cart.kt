package com.ecommerce.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "cart")
@Entity
open class Cart (){

    constructor(id: String, totalPrice: Double, status : String) : this()

    @Id
    @Column(name = "cart_id", nullable = false)
    var id: String = ""

    @Column(name = "total_price", nullable = false)
    var totalPrice: Double = 0.0

    @Column(name = "status", nullable = false)
    var status: String = ""
}