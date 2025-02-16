package com.ngnhng.demo.order.application.service

import com.ngnhng.demo.order.application.port.`in`.mgmt.CreateOrderDTO
import com.ngnhng.demo.order.application.port.`in`.mgmt.CreateOrderResultDTO
import com.ngnhng.demo.order.application.port.`in`.mgmt.OrderManagementPort
import com.ngnhng.demo.order.application.port.out.payment.PaymentServicePort
import org.springframework.stereotype.Service

@Service
class OrderManagementImpl(
    private val paymentService: PaymentServicePort
) : OrderManagementPort {
    override fun createOrder(request: CreateOrderDTO): CreateOrderResultDTO {
        println("OrderManagementImpl.createOrder")
        return CreateOrderResultDTO("order-id", "order-status")
    }
}