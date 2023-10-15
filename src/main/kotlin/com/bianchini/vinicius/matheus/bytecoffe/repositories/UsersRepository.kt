package com.bianchini.vinicius.matheus.bytecoffe.repositories

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface UsersRepository : JpaRepository<User, String> {

    fun findByEmail(email: String): UserDetails?
}