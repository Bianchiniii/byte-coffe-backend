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
    @Column(name = "id")
    val id: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "description")
    val description: String,
    @Column(name = "price_in_cents")
    val price_in_cents: Int,
    @Column(name = "category_id")
    val category_id: String,
    @Column(name = "image")
    val image: String
)