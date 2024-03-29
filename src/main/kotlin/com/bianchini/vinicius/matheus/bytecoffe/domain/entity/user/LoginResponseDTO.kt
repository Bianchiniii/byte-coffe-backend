package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.address.Address

@JvmRecord
data class LoginResponseDTO(
    val user: User,
    val address: Address,
    val token: String
)
