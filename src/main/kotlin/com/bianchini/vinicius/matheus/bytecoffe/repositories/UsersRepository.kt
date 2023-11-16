package com.bianchini.vinicius.matheus.bytecoffe.repositories

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.User
import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.UserRole
import jakarta.persistence.Column
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.security.core.userdetails.UserDetails

interface UsersRepository : JpaRepository<User, String> {

    fun findByEmail(email: String): UserDetails?

    @Modifying
    @Transactional
    @Query("update users u set u.name = :name, u.surname = :surname, u.email = :email, u.user_password = :user_password where u.id =:id")
    fun updateUserById(
        id: String,
        email: String,
        name: String,
        surname: String,
        user_password: String,
    )
}