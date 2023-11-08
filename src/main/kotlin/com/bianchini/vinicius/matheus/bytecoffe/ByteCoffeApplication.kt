package com.bianchini.vinicius.matheus.bytecoffe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class ByteCoffeApplication

fun main(args: Array<String>) {
    runApplication<ByteCoffeApplication>(*args)
}
