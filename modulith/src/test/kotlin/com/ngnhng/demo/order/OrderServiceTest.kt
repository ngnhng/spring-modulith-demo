package com.ngnhng.demo.order

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.test.context.event.ApplicationEvents
import org.springframework.test.context.event.ApplicationEventsTestExecutionListener
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.TestExecutionListeners.MergeMode

@SpringBootTest
@SpringJUnitConfig
@TestExecutionListeners(listeners = [ApplicationEventsTestExecutionListener::class], mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
class OrderServiceTest {

    @Autowired
    private lateinit var orderService: OrderService

    @Autowired
    private lateinit var applicationEventPublisher: ApplicationEventPublisher

    @Autowired
    private lateinit var applicationEvents: ApplicationEvents

    @Test
    fun testCreateOrder() {
        val orderDetails = "Sample order details"
        val orderId = orderService.createOrder(orderDetails)
        assertEquals(36, orderId.length) // UUID length
    }

    @Test
    fun testOrderCreatedEventPublishing() {
        val orderDetails = "Sample order details"
        val orderId = orderService.createOrder(orderDetails)

        val events = applicationEvents.stream(OrderCreatedEvent::class.java).toList()
        assertEquals(1, events.size)
        assertEquals(orderId, events[0].orderId)
        assertEquals(orderDetails, events[0].orderDetails)
    }
}
