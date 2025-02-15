package com.ngnhng.demo.notification

import com.ngnhng.demo.order.OrderCreatedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class NotificationEventListener(
    private val notificationService: NotificationService
) {

    @EventListener
    fun onOrderCreated(event: OrderCreatedEvent) {
        val message = "Order with ID: ${event.orderId} has been created with details: ${event.orderDetails}"
        notificationService.sendNotification(event.orderId, message)
    }
}
