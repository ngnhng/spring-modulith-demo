package com.ngnhng.demo.order.application.port.out.payment

data class OrderPaymentResultDTO(
    val success: Boolean,
    val orderId: String,
    val paymentId: String,
    val message: String?
)
