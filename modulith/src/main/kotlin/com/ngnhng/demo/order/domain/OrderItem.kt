package com.ngnhng.demo.order.domain

internal sealed class OrderItem {
    abstract val name: String
    abstract val price: Double
    abstract val quantity: Int
}
