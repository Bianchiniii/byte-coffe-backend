package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor
import java.util.*

@Table(name = "ticket")
@Entity(name = "ticket")
@EqualsAndHashCode(of = ["id"])
@AllArgsConstructor
@NoArgsConstructor
data class Ticket(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: String,
    val profile_id: String,
    val total_in_cents: Int,
    val order_status: String,
    val created_at: Date,
    val updated_at: Date
)
