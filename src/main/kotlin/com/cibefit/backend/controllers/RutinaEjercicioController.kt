package com.cibefit.backend.controllers

import com.cibefit.backend.models.RutinaEjercicio
import com.cibefit.backend.repositories.RutinaEjercicioRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rutina-ejercicios")
class RutinaEjercicioController(private val repository: RutinaEjercicioRepository) {

    @PostMapping
    fun añadirEjercicio(@RequestBody relacion: RutinaEjercicio) = repository.save(relacion)

    @GetMapping
    fun listarTodos() = repository.findAll()

    @GetMapping("/rutina/{rutinaId}")
    fun listarPorRutina(@PathVariable rutinaId: Long) = repository.findByRutinaId(rutinaId)


}