package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user

@JvmRecord
data class RegisterDTO(
    val email: String,
    val name: String,
    val surname: String,
    val password: String,
    val role: String
)
