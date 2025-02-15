package com.ngnhng.demo.order

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class OrderService(
    private val eventPublisher: ApplicationEventPublisher
) : OrderInternalAPI {
    override fun createOrder(orderDetails: String): String {
        // Implementation for creating an order
        val orderId = UUID.randomUUID().toString()
        println("Order created with ID: $orderId and details: $orderDetails")
        
        // Publish OrderCreatedEvent
        eventPublisher.publishEvent(OrderCreatedEvent(orderId, orderDetails))
        
        return orderId
    }
}
