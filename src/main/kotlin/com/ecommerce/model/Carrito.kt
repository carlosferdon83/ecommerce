package com.ecommerce.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "carrito")
data class Carrito(
    @Id
    val id: String = "",
    @Column
    val arrayListProducts: ArrayList<Product> = ArrayList<Product>()
){}
