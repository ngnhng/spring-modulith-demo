package com.ngnhng.demo.order.application.mapper

import com.ngnhng.demo.order.adapter.`in`.restful.api.v1.dto.request.CreateOrderRequestDTO
import com.ngnhng.demo.order.application.port.`in`.mgmt.CreateOrderDTO
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface OrderMapper {
    fun toModel(request: CreateOrderRequestDTO): CreateOrderDTO;
}