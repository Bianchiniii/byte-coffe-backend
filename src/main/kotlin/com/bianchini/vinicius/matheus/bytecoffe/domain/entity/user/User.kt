package com.bianchini.vinicius.matheus.bytecoffe.domain.entity.user

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Table(name = "users")
@Entity(name = "users")
@EqualsAndHashCode(of = ["id"])
@AllArgsConstructor
@NoArgsConstructor
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: String,
    @Column(name = "email")
    val email: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "surname")
    val surname: String,
    @Column(name = "user_password")
    val user_password: String,
    @Column(name = "role")
    val role: UserRole,
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(
            when (role) {
                UserRole.ADMIN -> {
                    SimpleGrantedAuthority("ROLE_ADMIN")
                    SimpleGrantedAuthority("ROLE_USER")
                }

                UserRole.USER -> SimpleGrantedAuthority("ROLE_USER")
            }
        )
    }

    override fun getPassword(): String {
        return user_password
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
