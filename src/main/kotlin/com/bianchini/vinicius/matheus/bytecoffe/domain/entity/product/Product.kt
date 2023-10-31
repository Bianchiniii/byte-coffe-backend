package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.product

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor

@Table(name = "product")
@Entity(name = "product")
@EqualsAndHashCode(of = ["id"])
@AllArgsConstructor
@NoArgsConstructor
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String,
    val name: String,
    val price_in_cents: Int,
    val category_id: String,
    val image: String
)