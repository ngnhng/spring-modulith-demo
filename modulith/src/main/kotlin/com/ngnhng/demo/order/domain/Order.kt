package com.ngnhng.demo.order.domain

import java.time.OffsetDateTime


internal interface OrderFields {
    val orderId: String
    val orderItems: List<OrderItem>
}

internal data class OrderData(
    override val orderId: String,
    override val orderItems: List<OrderItem>
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
    val reason: String
) : Order(
), OrderFields by data {

    companion object {
        fun of(orderId: String, orderItems: List<OrderItem>, reason: String): FailedOrder {
            return FailedOrder(OrderData(orderId, orderItems), reason)
        }

        fun of(newOrder: NewOrder, reason: String): FailedOrder {
            return FailedOrder(OrderData(newOrder.orderId, newOrder.orderItems), reason)
        }
    }
}