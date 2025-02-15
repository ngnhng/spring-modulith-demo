package com.ngnhng.demo.order.application.port.`in`.mgmt

interface OrderManagementPort {
    fun createOrder(request: CreateOrderDTO): CreateOrderResultDTO
}