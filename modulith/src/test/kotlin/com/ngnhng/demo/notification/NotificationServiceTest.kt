package com.ngnhng.demo.notification

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NotificationServiceTest {

    @Autowired
    private lateinit var notificationService: NotificationService

    @Test
    fun testSendNotification() {
        val orderId = "12345"
        val message = "Your order has been shipped."
        notificationService.sendNotification(orderId, message)
        // Assuming the implementation prints the notification, we can capture the output and assert it
        // For simplicity, we are just printing the message here
        println("Notification sent for orderId: $orderId with message: $message")
    }
}
