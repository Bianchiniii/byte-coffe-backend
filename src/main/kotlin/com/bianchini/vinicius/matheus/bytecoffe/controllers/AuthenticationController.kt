package com.bianchini.vinicius.matheus.bytecoffe.controllers

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.AuthenticationDTO
import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.RegisterDTO
import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.User
import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.UserRole
import com.bianchini.vinicius.matheus.bytecoffe.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
@RequestMapping("auth")
class AuthenticationController {

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var usersRepository: UsersRepository

    @PostMapping("/login")
    fun login(
        @RequestBody data: AuthenticationDTO
    ): ResponseEntity<Any> {
        val userNamePasswordAuthentication = UsernamePasswordAuthenticationToken(data.login, data.password)
        val auth = authenticationManager.authenticate(userNamePasswordAuthentication)

        return ResponseEntity.ok().build()
    }

    @PostMapping("/register")
    fun register(
        @RequestBody data: RegisterDTO
    ): ResponseEntity<Any> {
        if (usersRepository.findByEmail(data.email) != null) return ResponseEntity.badRequest().build()

        val encryptedPassword = BCryptPasswordEncoder().encode(data.password)
        val user = User(
            id = UUID.randomUUID().toString(),
            email = data.email,
            name = data.name,
            surname = data.surname,
            user_password = encryptedPassword,
            role = UserRole.findByString(data.role)
        )

        usersRepository.save(user)

        return ResponseEntity.ok().build()
    }
}