package com.ngnhng.demo.order.domain

enum class OrderState {
    CREATED,
    PAYMENT_WAITING,
    PAYMENT_COMPLETED,
    PREPARING,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED
}