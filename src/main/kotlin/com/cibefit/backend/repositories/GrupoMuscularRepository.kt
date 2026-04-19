package com.cibefit.backend.repositories

import com.cibefit.backend.models.GrupoMuscular
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GrupoMuscularRepository : JpaRepository<GrupoMuscular, Long> {
    // Al extender JpaRepository, ya tienes automáticamente:
    // findAll(), findById(), save(), delete(), etc.
    // No hace falta escribir nada más por ahora.
}