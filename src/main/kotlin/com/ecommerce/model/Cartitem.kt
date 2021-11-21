package com.ecommerce.model

import javax.persistence.*

@Table(name = "cartitems")
@Entity
open class Cartitem {
    @Id
    @Column(name = "cart_item_id", nullable = false)
    open var id: String = ""

    @Column(name = "price_item", nullable = false)
    open var price: Double = 0.0

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    open var product: Product = Product()

    @Column(name = "quantity", nullable = false)
    open var quantity: Int = 0

    @ManyToOne(optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    open var cart: Cart = Cart()
}