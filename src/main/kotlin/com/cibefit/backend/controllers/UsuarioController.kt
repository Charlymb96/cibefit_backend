package com.cibefit.backend.controllers

import com.cibefit.backend.models.Usuario
import com.cibefit.backend.repositories.UsuarioRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/usuarios")
class UsuarioController(private val usuarioRepository: UsuarioRepository) {


    @GetMapping
    fun obtenerUsuarios(): List<Usuario> {
        return usuarioRepository.findAll()
    }


    @PostMapping
    fun registrarUsuario(@RequestBody nuevoUsuario: Usuario): Usuario {
        return usuarioRepository.save(nuevoUsuario)
    }
}