package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.updateuser

data class UpdateUserDTO(
    val id: String,
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
)