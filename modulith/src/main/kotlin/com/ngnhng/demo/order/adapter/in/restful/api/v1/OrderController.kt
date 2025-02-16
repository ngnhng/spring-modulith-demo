package com.ngnhng.demo.order.adapter.`in`.restful.api.v1

import com.ngnhng.demo.order.adapter.`in`.restful.api.v1.dto.request.CreateOrderRequestDTO
import com.ngnhng.demo.order.application.mapper.OrderMapper
import com.ngnhng.demo.order.application.port.`in`.mgmt.OrderManagementPort
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/v1/orders")
class OrderController(
    private val orderManagement: OrderManagementPort,
    private val mapper: OrderMapper
) {
    @PostMapping
    suspend fun createOrder(
        @Valid
        @RequestBody request: CreateOrderRequestDTO
    ): ResponseEntity<Void> {
        orderManagement.createOrder(mapper.toModel(request))

        return ResponseEntity.ok().build();
    }
}