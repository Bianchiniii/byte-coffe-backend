package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.address.Address

data class RegisterResponseDTO (
    val user: User,
    val address: Address,
    val token: String
)