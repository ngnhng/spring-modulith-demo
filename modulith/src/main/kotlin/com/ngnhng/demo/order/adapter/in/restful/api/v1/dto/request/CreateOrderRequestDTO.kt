package com.ngnhng.demo.order.adapter.`in`.restful.api.v1.dto.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty

data class CreateOrderRequestDTO(
    @field:NotBlank
    val customerId: String,
    @field:NotEmpty
    val items: List<OrderItemDTO>
) {
    data class OrderItemDTO(
        @field:NotBlank
        val productId: String,
        @field:Min(1)
        val quantity: Int
    )
}
