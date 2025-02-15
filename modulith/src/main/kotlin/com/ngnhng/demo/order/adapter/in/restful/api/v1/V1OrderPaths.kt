package com.ngnhng.demo.order.adapter.`in`.restful.api.v1

internal object V1OrderPaths {
    private const val BASE_PATH = "/api/v1/orders"

    const val CREATE_ORDER = BASE_PATH
    const val GET_ORDER = "$BASE_PATH/{orderId}"
}
