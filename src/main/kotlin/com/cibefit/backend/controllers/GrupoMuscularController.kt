package com.cibefit.backend.controllers

import com.cibefit.backend.models.GrupoMuscular
import com.cibefit.backend.repositories.GrupoMuscularRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/grupos")
class GrupoMuscularController(private val repository: GrupoMuscularRepository) {

    @GetMapping
    fun listar() = repository.findAll()

    @PostMapping
    fun crear(@RequestBody grupo: GrupoMuscular) = repository.save(grupo)
}