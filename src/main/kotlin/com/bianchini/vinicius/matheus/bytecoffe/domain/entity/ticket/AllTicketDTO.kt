package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket

import java.util.*

data class AllTicketDTO(
    val tickets: MutableList<Order>
)

data class Order(
    val id: String,
    val createdAt: String,
    val total: Int,
    val status: String,
    val orderProducts: List<OrderProduct>
)

data class OrderProduct(
    val productId: String,
    val productName: String,
    val quantity: Int
)