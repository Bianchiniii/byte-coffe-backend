package com.bianchini.vinicius.matheus.bytecoffe.controllers

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket.*
import com.bianchini.vinicius.matheus.bytecoffe.repositories.OrderProductsRepository
import com.bianchini.vinicius.matheus.bytecoffe.repositories.ProductRepository
import com.bianchini.vinicius.matheus.bytecoffe.repositories.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*


@RestController
@RequestMapping("ticket")
class TicketController {

    @Autowired
    lateinit var ticketRepository: TicketRepository

    @Autowired
    lateinit var orderProductRepository: OrderProductsRepository

    @Autowired
    lateinit var productRepository: ProductRepository

    @PostMapping("/create")
    fun createOrder(
        @RequestBody data: TicketDTO
    ): ResponseEntity<TicketResponseDTO> {
        val orderUUID = UUID.randomUUID().toString()
        val ticket = Ticket(
            id = orderUUID,
            profileId = data.profileId,
            totalInCents = data.totalInCents,
            orderStatus = OrderStatus.PENDING.value,
            createdAt = Date(),
            updatedAt = null,
        )

        val createdTicket = ticketRepository.save(ticket)

        val listOrderProducts = data.orderProducts.map {
            OrderProducts(
                id = UUID.randomUUID().toString(),
                orderId = createdTicket.id,
                productId = it.productId,
                quantity = it.quantity
            )
        }

        for (orderProducts in listOrderProducts) {
            orderProductRepository.save(orderProducts)
        }

        return ResponseEntity.ok(TicketResponseDTO(true))
    }

    @PostMapping("/all-orders")
    fun getAllOrderByProfileId(
        @RequestBody data: AllTicketByUserDTO
    ): ResponseEntity<AllTicketDTO> {
        val userId = data.profile_id

        val allOrderByProfileId = AllTicketDTO(mutableListOf())

        val allTickets = ticketRepository.getAllTicketsByUserId(userId)

        for (ticket in allTickets) {
            val productsOnTicket = orderProductRepository.getProductsByOrderId(ticket.id)

            val orderProducts = mutableListOf<OrderProduct>()
            for (product in productsOnTicket) {
                val productInfo = productRepository.findById(product.productId).get()

                orderProducts.add(
                    OrderProduct(
                        productInfo.id,
                        productInfo.name,
                        product.quantity,
                    )
                )
            }

            val pattern = "dd/MM/yyyy"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val createdAtFormated = simpleDateFormat.format(ticket.createdAt)

            val order = Order(
                ticket.id,
                createdAtFormated,
                ticket.totalInCents,
                ticket.orderStatus,
                orderProducts = orderProducts
            )

            allOrderByProfileId.tickets.add(order)
        }

        allOrderByProfileId.tickets.sortByDescending  {
            it.createdAt
        }

        return ResponseEntity.ok(allOrderByProfileId)
    }
}