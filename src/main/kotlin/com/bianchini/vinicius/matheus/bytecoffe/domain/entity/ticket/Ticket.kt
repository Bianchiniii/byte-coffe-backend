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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: String,
    @Column(name = "profile_id")
    val profileId: String,
    @Column(name = "total_in_cents")
    val totalInCents: Int,
    @Column(name = "order_status")
    val orderStatus: String,
    @Column(name = "created_at")
    val createdAt: Date,
    @Column(name = "updated_at")
    val updatedAt: Date? = null
)
