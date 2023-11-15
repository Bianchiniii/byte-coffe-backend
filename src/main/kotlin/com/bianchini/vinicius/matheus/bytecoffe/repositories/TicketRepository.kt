package com.bianchini.vinicius.matheus.bytecoffe.repositories

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket.Ticket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TicketRepository : JpaRepository<Ticket, String> {

    @Query("from ticket t where t.profileId = :profileId")
    fun getAllTicketsByUserId(profileId: String): List<Ticket>

}