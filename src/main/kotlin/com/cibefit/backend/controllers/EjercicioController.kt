package com.cibefit.backend.controller

import com.cibefit.backend.models.Ejercicio
import com.cibefit.backend.repository.EjercicioRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ejercicios")
class EjercicioController(private val repository: EjercicioRepository) {

    @GetMapping
    fun listar(): List<Ejercicio> {
        return repository.findAll()
    }

    @PostMapping
    fun crear(@RequestBody ejercicio: Ejercicio): Ejercicio {
        return repository.save(ejercicio)
    }
}