package com.cibefit.backend.repositories

import com.cibefit.backend.models.Rutina
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RutinaRepository : JpaRepository<Rutina, Long>