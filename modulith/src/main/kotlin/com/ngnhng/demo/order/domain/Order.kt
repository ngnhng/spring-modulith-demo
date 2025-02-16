package com.ngnhng.demo.order.domain

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.OffsetDateTime


internal interface OrderFields {
    val orderId: String
    val orderItems: List<OrderItem>
    val totalAmount: Double
        get() = orderItems.sumOf { it.price }

    val totalQuantity: Int
        get() = orderItems.sumOf { it.quantity }

    val creationTimestamp: OffsetDateTime;
}

internal data class OrderData(
    @field:NotBlank
    override val orderId: String,
    @field:NotEmpty
    override val orderItems: List<OrderItem>,
    @field:NotNull
    override val creationTimestamp: OffsetDateTime = OffsetDateTime.now()
) : OrderFields

internal sealed class Order : OrderFields {
}

internal data class NewOrder(
    private val data: OrderData
) : Order(
), OrderFields by data {

    companion object {
        fun of(orderId: String, orderItems: List<OrderItem>): NewOrder {
            return NewOrder(OrderData(orderId, orderItems))
        }
    }
}

internal data class PaidOrder(
    private val data: OrderData,
    val completeTimestamp: OffsetDateTime
) : Order(
), OrderFields by data {

    companion object {
        fun of(orderId: String, orderItems: List<OrderItem>, timestamp: OffsetDateTime): PaidOrder {
            return PaidOrder(OrderData(orderId, orderItems), timestamp)
        }

        fun of(newOrder: NewOrder, timestamp: OffsetDateTime): PaidOrder {
            return PaidOrder(OrderData(newOrder.orderId, newOrder.orderItems), timestamp)
        }
    }
}

internal data class FailedOrder(
    private val data: OrderData,
    val cancelledTimestamp: OffsetDateTime = OffsetDateTime.now(),
    val reason: String
) : Order(
), OrderFields by data {

    companion object {
        fun of(
            orderId: String,
            orderItems: List<OrderItem>,
            reason: String,
            cancelledTimestamp: OffsetDateTime
        ): FailedOrder {
            return FailedOrder(OrderData(orderId, orderItems), cancelledTimestamp, reason)
        }

        fun of(newOrder: NewOrder, reason: String, cancelledTimestamp: OffsetDateTime): FailedOrder {
            return FailedOrder(OrderData(newOrder.orderId, newOrder.orderItems), cancelledTimestamp, reason)
        }
    }
}