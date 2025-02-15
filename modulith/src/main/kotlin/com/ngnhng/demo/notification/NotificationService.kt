package com.ngnhng.demo.notification

import org.springframework.stereotype.Service

@Service
class NotificationService : NotificationInternalAPI {
    override fun sendNotification(orderId: String, message: String) {
        // Implementation for sending notification
        println("Notification sent for orderId: $orderId with message: $message")
    }
}
