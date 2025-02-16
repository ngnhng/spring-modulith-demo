package com.ngnhng.demo.order.adapter.out.rest.payment

import com.ngnhng.demo.order.application.port.out.payment.OrderPaymentResultDTO
import com.ngnhng.demo.order.application.port.out.payment.PaymentServicePort
import org.springframework.stereotype.Service

@Service
class PaymentServiceAdapter(): PaymentServicePort {
    override suspend fun processOrderPayment(orderId: String): OrderPaymentResultDTO {
        TODO("Not yet implemented")
    }
}