package com.bianchini.vinicius.matheus.bytecoffe.controllers

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.product.Product
import com.bianchini.vinicius.matheus.bytecoffe.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController {

    @Autowired
    lateinit var productRepository: ProductRepository

    @GetMapping("/all")
    fun getAllProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productRepository.findAll())
    }
}