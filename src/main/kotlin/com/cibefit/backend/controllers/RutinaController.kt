package com.cibefit.backend.controllers

import com.cibefit.backend.models.Rutina
import com.cibefit.backend.repositories.RutinaRepository
import com.cibefit.backend.repositories.UsuarioRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rutinas")
class RutinaController(
    private val rutinaRepository: RutinaRepository,
    private val usuarioRepository: UsuarioRepository // <-- 1. Inyectamos esto
) {

    @PostMapping
    fun crearRutina(@RequestBody rutina: Rutina): Rutina {
        // 2. Obtenemos el email del usuario logueado desde el token
        val email = SecurityContextHolder.getContext().authentication?.name
            ?: throw RuntimeException("Usuario no autenticado")

        // 3. Buscamos al usuario en la base de datos
        val usuario = usuarioRepository.findByEmail(email)
            ?: throw RuntimeException("Usuario no encontrado")

        // 4. Creamos una copia de la rutina con el creador asignado automáticamente
        // (Usamos .copy porque los data class son inmutables)
        val rutinaConCreador = rutina.copy(creador = usuario)

        // 5. Guardamos
        return rutinaRepository.save(rutinaConCreador)
    }
}