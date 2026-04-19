package com.cibefit.backend.controllers

import com.cibefit.backend.dtos.LoginRequest
import com.cibefit.backend.dtos.RegisterRequest
import com.cibefit.backend.models.RolUsuario
import com.cibefit.backend.models.Usuario
import com.cibefit.backend.repositories.UsuarioRepository
import com.cibefit.backend.security.JwtTokenProvider
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider,
    private val repository: UsuarioRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<String> {
        if (repository.findByEmail(request.email) != null) {
            return ResponseEntity.badRequest().body("El email ya existe")
        }

        val encodedPassword = passwordEncoder.encode(request.password)

        val nuevoUsuario = Usuario(
            username = request.username,
            email = request.email,
            password = encodedPassword!!,
            altura = request.altura,
            peso = request.peso,
            rol = RolUsuario.USER
        )

        repository.save(nuevoUsuario)
        return ResponseEntity.ok("Usuario registrado con éxito")
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Map<String, String>> {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.email, request.password)
        )

        val token = jwtTokenProvider.generateToken(authentication)
        return ResponseEntity.ok(mapOf("token" to token))
    }
}