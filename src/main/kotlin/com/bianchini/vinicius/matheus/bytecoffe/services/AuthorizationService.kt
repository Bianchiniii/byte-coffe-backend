package com.bianchini.vinicius.matheus.bytecoffe.services

import com.bianchini.vinicius.matheus.bytecoffe.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService : UserDetailsService {

    @Autowired
    lateinit var usersRepository: UsersRepository

    override fun loadUserByUsername(username: String?): UserDetails? {
        return username?.let {
            usersRepository.findByEmail(it)
        } ?: run {
            null
        }
    }
}