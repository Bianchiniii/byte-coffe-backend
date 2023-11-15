package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.address

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor

@Table(name = "address")
@Entity(name = "address")
@EqualsAndHashCode(of = ["id"])
@AllArgsConstructor
@NoArgsConstructor
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: String,
    @Column(name = "street")
    val street: String,
    @Column(name = "neighborhood")
    val neighborhood: String,
    @Column(name = "number")
    val number: String,
    @Column(name = "city_and_state")
    val city_and_state: String,
    @Column(name = "profile_id")
    val profile_id: String,
)
