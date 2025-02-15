package com.ngnhng.demo.order.application.port.out.payment

interface PaymentServicePort {
    suspend fun processOrderPayment(orderId: String): OrderPaymentResultDTO
}