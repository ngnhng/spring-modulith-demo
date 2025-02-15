package com.ngnhng.demo.order

data class OrderCreatedEvent(
    val orderId: String,
    val orderDetails: String
)
