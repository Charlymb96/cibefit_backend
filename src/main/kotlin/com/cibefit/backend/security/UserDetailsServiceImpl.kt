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
        // Buscamos al usuario en tu base de datos
        val usuario = repository.findByEmail(email)
            ?: throw UsernameNotFoundException("Usuario no encontrado con email: $email")

        // Retornamos el formato que Spring Security entiende
        return User.builder()
            .username(usuario.email)
            .password(usuario.password) // ¡IMPORTANTE: Aquí debe ir la contraseña encriptada!
            .roles(usuario.rol.name)
            .build()
    }
}