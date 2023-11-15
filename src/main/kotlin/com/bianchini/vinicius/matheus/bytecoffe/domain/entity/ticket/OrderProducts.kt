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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: String,
    @Column(name = "order_id")
    val orderId: String,
    @Column(name = "product_id")
    val productId: String,
    @Column(name = "quantity")
    val quantity: Int
)