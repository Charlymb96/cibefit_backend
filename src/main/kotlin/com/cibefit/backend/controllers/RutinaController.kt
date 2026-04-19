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
    private val usuarioRepository: UsuarioRepository
) {

    @PostMapping
    fun crearRutina(@RequestBody rutina: Rutina): Rutina {

        val email = SecurityContextHolder.getContext().authentication?.name
            ?: throw RuntimeException("Usuario no autenticado")


        val usuario = usuarioRepository.findByEmail(email)
            ?: throw RuntimeException("Usuario no encontrado")


        val rutinaConCreador = rutina.copy(creador = usuario)


        return rutinaRepository.save(rutinaConCreador)
    }
}