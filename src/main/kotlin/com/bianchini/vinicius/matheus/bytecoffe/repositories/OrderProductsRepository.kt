package com.bianchini.vinicius.matheus.bytecoffe.repositories

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.ticket.OrderProducts
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface OrderProductsRepository : JpaRepository<OrderProducts, String>{

    @Query("from order_products op where op.orderId = :orderId")
    fun getProductsByOrderId(orderId:String): List<OrderProducts>
}