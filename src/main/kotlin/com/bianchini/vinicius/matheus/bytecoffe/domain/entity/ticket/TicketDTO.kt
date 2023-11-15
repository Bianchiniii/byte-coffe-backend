package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket

data class TicketDTO(
    val profileId: String,
    val deliveryType: String,
    val paymentMethod: String,
    val orderProducts: List<OrderProductsDTO>,
    val totalInCents: Int
)

data class OrderProductsDTO(
    val productId: String,
    val quantity: Int
)