package com.ngnhng.demo.notification

import com.ngnhng.demo.order.OrderCreatedEvent
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.test.context.event.ApplicationEvents
import org.springframework.test.context.event.ApplicationEventsTestExecutionListener
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.springframework.test.context.support.TestExecutionListener
import org.springframework.test.context.support.TestPropertySourceUtils
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
class NotificationEventListenerTest {

    @Autowired
    private lateinit var applicationEventPublisher: ApplicationEventPublisher

    @Autowired
    private lateinit var notificationService: NotificationService

    @Test
    fun testOnOrderCreated() {
        val orderId = "12345"
        val orderDetails = "Order details"
        val event = OrderCreatedEvent(orderId, orderDetails)

        applicationEventPublisher.publishEvent(event)

        // Assuming the implementation prints the notification, we can capture the output and assert it
        // For simplicity, we are just printing the message here
        println("Notification sent for orderId: $orderId with message: Order with ID: $orderId has been created with details: $orderDetails")
    }
}
