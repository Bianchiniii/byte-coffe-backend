package com.bianchini.vinicius.matheus.bytecoffe.jobs.order

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket.OrderStatus
import com.bianchini.vinicius.matheus.bytecoffe.repositories.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.logging.Logger

@Component
class OrderJob {

    @Autowired
    lateinit var ticketRepository: TicketRepository

    @Scheduled(fixedRate = 20000)
    fun setFinishedOrdersJob() {
        val allPendingOrders = ticketRepository.getAppTicketWithStatus(OrderStatus.PENDING.value)

        if (allPendingOrders != null) {
            for (order in allPendingOrders) {
                ticketRepository.updateOrderStatusByTicketId(OrderStatus.FINISHED.value, order.id)
            }
        }

        Logger.getGlobal().info(
            "Run finished orders at ${DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now())}"
        )
    }
}