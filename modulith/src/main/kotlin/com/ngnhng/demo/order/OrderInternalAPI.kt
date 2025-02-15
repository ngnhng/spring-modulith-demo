package com.ngnhng.demo.order

interface OrderInternalAPI {
    fun createOrder(orderDetails: String): String
}
