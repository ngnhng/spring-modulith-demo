package com.ngnhng.demo.payment

interface PaymentInternalAPI {
    fun checkoutOrder(orderId: String)
}