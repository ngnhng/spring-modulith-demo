package com.ngnhng.demo.order.adapter.`in`.restful.api.v1

import com.ngnhng.demo.order.adapter.`in`.restful.api.v1.dto.request.CreateOrderRequestDTO
import com.ngnhng.demo.order.application.mapper.OrderMapper
import com.ngnhng.demo.order.application.port.`in`.mgmt.OrderManagementPort
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
sealed class OrderController(
    private val orderManagement: OrderManagementPort,
    private val mapper: OrderMapper
) {
    @PostMapping(path = [V1OrderPaths.CREATE_ORDER])
    suspend fun createOrder(
        @RequestBody request: CreateOrderRequestDTO
    ) {
        orderManagement.createOrder(mapper.toModel(request))
    }
}