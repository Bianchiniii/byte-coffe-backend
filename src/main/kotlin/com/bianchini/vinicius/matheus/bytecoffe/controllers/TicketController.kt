package com.bianchini.vinicius.matheus.bytecoffe.controllers

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket.TicketDTO
import com.bianchini.vinicius.matheus.bytecoffe.repositories.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ticket")
class TicketController {

    @Autowired
    lateinit var ticketRepository: TicketRepository

    @PostMapping("/create")
    fun createOrder(
        @RequestBody ticketDTO: TicketDTO
    ): ResponseEntity<Boolean> {
        // TODO: impl salvar e validar

        return ResponseEntity.ok(true)
    }
}