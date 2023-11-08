package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor

@Table(name = "order_products")
@Entity(name = "order_products")
@EqualsAndHashCode(of = ["id"])
@AllArgsConstructor
@NoArgsConstructor
data class OrderProducts(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: String,
    val order_id: String,
    val subtotal_in_cents: Int,
    val quantity: Int
)