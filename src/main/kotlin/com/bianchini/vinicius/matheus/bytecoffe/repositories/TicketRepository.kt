package com.bianchini.vinicius.matheus.bytecoffe.repositories

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket.Ticket
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface TicketRepository : JpaRepository<Ticket, String> {

    @Query("from ticket t where t.profileId = :profileId")
    fun getAllTicketsByUserId(profileId: String): List<Ticket>

    @Modifying
    @Transactional
    @Query("update ticket t set t.orderStatus = :orderStatus where t.id =:ticketId")
    fun updateOrderStatusByTicketId(orderStatus: String, ticketId: String)

    @Query("from ticket t where t.orderStatus like :orderStatus")
    fun getAppTicketWithStatus(@Param("orderStatus") status: String): List<Ticket>?
}