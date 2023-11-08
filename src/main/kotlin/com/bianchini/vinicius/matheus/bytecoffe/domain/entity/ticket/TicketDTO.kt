package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket

data class TicketDTO(
    val deliveryType: String,
    val paymentMethod: String,
    val orderProducts: List<OrderProductsDTO>
)

data class OrderProductsDTO(
    val productId: String,
    val quantity: Int
)