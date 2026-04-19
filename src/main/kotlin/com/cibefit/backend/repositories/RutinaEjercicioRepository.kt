package com.cibefit.backend.repositories

import com.cibefit.backend.models.RutinaEjercicio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RutinaEjercicioRepository : JpaRepository<RutinaEjercicio, Long> {
    fun findByRutinaId(rutinaId: Long): List<RutinaEjercicio>
}