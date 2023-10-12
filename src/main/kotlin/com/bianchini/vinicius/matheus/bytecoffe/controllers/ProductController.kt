package com.bianchini.vinicius.matheus.bytecoffe.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController {

    @GetMapping
    fun getAllProduct(): ResponseEntity<Any> {
        return ResponseEntity.ok("deu boa!")
    }
}