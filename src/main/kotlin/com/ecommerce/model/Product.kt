package com.ecommerce.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "products")
@Entity
open class Product() {
    constructor(id: String,
                name: String,
                description: String,
                sku: String,
                price: Double,
                stock: Long,
                type: String) : this() {
    }

    @Id
    @Column(name = "product_id", nullable = false)
    var id: String = ""

    @Column(name = "name", nullable = false)
    var name: String = ""

    @Column(name = "description", nullable = false)
    var description: String = ""

    @Column(name = "sku", nullable = false)
    var sku: String = ""

    @Column(name = "price", nullable = false)
    var price: Double = 0.0

    @Column(name = "stock", nullable = false)
    var stock: Long = 0

    @Column(name = "type", length = 30)
    var type: String = ""
}