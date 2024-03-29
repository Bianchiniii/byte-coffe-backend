package com.bianchini.vinicius.matheus.bytecoffe.controllers

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.address.Address
import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.*
import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.updateuser.UpdateUserDTO
import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user.updateuser.UpdatedResponseDTO
import com.bianchini.vinicius.matheus.bytecoffe.infra.security.TokenService
import com.bianchini.vinicius.matheus.bytecoffe.repositories.AddressRepository
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

    @Autowired
    lateinit var addressRepository: AddressRepository

    @Autowired
    lateinit var tokenService: TokenService

    @PostMapping("/login")
    fun login(
        @RequestBody data: AuthenticationDTO
    ): ResponseEntity<LoginResponseDTO> {
        val userNamePasswordAuthentication = UsernamePasswordAuthenticationToken(data.login, data.password)
        val auth = authenticationManager.authenticate(userNamePasswordAuthentication)

        val token = tokenService.generateToken(auth.principal as User)

        val user = auth.principal as User

        val address = addressRepository.findByProfileId(user.id)!!

        return ResponseEntity.ok(
            LoginResponseDTO(
                user = user,
                token = token!!,
                address = address
            )
        )
    }

    @PostMapping("/register")
    fun register(
        @RequestBody data: RegisterDTO
    ): ResponseEntity<RegisterResponseDTO> {
        val dataProfileInfo = data.profile_info
        val dataAddress = data.address

        if (usersRepository.findByEmail(dataProfileInfo.email) != null) return ResponseEntity.badRequest().build()

        val encryptedPassword = BCryptPasswordEncoder().encode(dataProfileInfo.password)

        val user = User(
            id = UUID.randomUUID().toString(),
            email = dataProfileInfo.email,
            name = dataProfileInfo.name,
            surname = dataProfileInfo.surname,
            user_password = encryptedPassword,
            role = UserRole.findByString(dataProfileInfo.role),
        )

        val createdUser = usersRepository.save(user)

        val saveAddress = Address(
            id = UUID.randomUUID().toString(),
            street = dataAddress.street,
            neighborhood = dataAddress.neighborhood,
            number = dataAddress.number,
            city_and_state = dataAddress.city_and_state,
            profile_id = createdUser.id
        )

        addressRepository.save(saveAddress)


        val userNamePasswordAuthentication =
            UsernamePasswordAuthenticationToken(data.profile_info.email, data.profile_info.password)
        val auth = authenticationManager.authenticate(userNamePasswordAuthentication)

        val token = tokenService.generateToken(auth.principal as User)

        return ResponseEntity.ok(
            RegisterResponseDTO(
                user = user,
                address = saveAddress,
                token = token!!
            )
        )
    }

    @PostMapping("/update-profile")
    fun updateUser(
        @RequestBody data: UpdateUserDTO
    ): ResponseEntity<UpdatedResponseDTO> {
        if (usersRepository.findByEmail(data.email) != null) return ResponseEntity.badRequest().build()

        val encryptedPassword = BCryptPasswordEncoder().encode(data.password)

        usersRepository.updateUserById(
            id = data.id,
            email = data.email,
            name = data.name,
            surname = data.surname,
            user_password = encryptedPassword

        )

        val user = usersRepository.findByEmail(data.email) as User

        return ResponseEntity.ok(
            UpdatedResponseDTO(
                user = user
            )
        )
    }
}