package com.bianchini.vinicius.matheus.bytecoffe.infra.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.User
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset


@Service
class TokenService {

    @org.springframework.beans.factory.annotation.Value("\${api.security.token.secret}")
    lateinit var secret: String

    fun generateToken(user: User): String? {
        runCatching {
            val algorithm = Algorithm.HMAC256(secret)

            return JWT.create().withIssuer("byte-coffee-api")
                .withSubject(user.email)
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm)
        }.onFailure {
            throw RuntimeException("Error while generation token", it)
        }

        return null
    }

    fun validateToken(token: String?): String {
        return try {
            val algorithm = Algorithm.HMAC256(secret)
            JWT.require(algorithm)
                .withIssuer("byte-coffee-api")
                .build()
                .verify(token)
                .subject
        } catch (exception: JWTVerificationException) {
            ""
        }
    }

    private fun generateExpirationDate(): Instant {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"))
    }
}