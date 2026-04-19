package com.cibefit.backend.security

import com.cibefit.backend.repositories.UsuarioRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val repository: UsuarioRepository) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {

        val usuario = repository.findByEmail(email)
            ?: throw UsernameNotFoundException("Usuario no encontrado con email: $email")


        return User.builder()
            .username(usuario.email)
            .password(usuario.password)
            .roles(usuario.rol.name)
            .build()
    }
}