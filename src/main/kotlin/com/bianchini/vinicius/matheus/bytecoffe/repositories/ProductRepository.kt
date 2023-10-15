package com.bianchini.vinicius.matheus.bytecoffe.repositories

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.product.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String>