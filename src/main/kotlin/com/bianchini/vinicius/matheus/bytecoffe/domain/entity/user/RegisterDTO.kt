package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user

@JvmRecord
data class RegisterDTO(
    val profile_info: ProfileInfo,
    val address: Address,
)

@JvmRecord
data class ProfileInfo(
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    val role: String,
)

@JvmRecord
data class Address(
    val street: String,
    val number: String,
    val neighborhood: String,
    val city_and_state: String,
)