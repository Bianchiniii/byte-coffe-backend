package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.address

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor

@Table(name = "address")
@Entity(name = "addresst")
@EqualsAndHashCode(of = ["id"])
@AllArgsConstructor
@NoArgsConstructor
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,
    val street: String,
    val neighborhood: String,
    val number: String,
    val city_and_state: String,
    val profile_id: String,
)
