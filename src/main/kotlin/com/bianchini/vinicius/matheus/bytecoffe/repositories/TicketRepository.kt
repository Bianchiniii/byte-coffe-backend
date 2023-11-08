package com.bianchini.vinicius.matheus.bytecoffe.repositories

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket.Ticket
import org.springframework.data.jpa.repository.JpaRepository

interface TicketRepository : JpaRepository<Ticket, String>