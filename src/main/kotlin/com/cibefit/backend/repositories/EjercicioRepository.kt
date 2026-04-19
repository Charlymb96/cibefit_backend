package com.cibefit.backend.repository

import com.cibefit.backend.models.Ejercicio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EjercicioRepository : JpaRepository<Ejercicio, Long>