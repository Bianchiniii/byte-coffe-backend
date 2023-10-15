package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user

enum class UserRole(val role: String) {
    ADMIN("admin"),
    USER("user");

    companion object {
        fun findByString(role: String): UserRole {
            return when (role) {
                "admin" -> ADMIN
                "user" -> USER

                else -> USER
            }
        }
    }
}