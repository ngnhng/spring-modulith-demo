package com.ngnhng.demo.payment.application.service

import com.ngnhng.demo.payment.PaymentInternalAPI
import org.springframework.stereotype.Service

@Service
class PaymentManagement(
    private val orderCheckoutService: OrderCheckoutService
) : PaymentInternalAPI {
    override fun checkoutOrder(orderId: String) {
        println("PaymentManagement.checkoutOrder")
    }
}