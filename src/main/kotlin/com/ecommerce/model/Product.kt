package com.ecommerce.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id

@Entity
@Table(name = "producto")
data class Product(

    @Id
    var id: String = "",
    @Column
    var nombre: String = "",
    @Column
    var sku: String = "",
    @Column
    var precio: Double = 0.0,
    @Column
    var descripcion: String = "",
    @Column
    var tipo: String = "",
    @Column
    var stock: Int = 0
){}
