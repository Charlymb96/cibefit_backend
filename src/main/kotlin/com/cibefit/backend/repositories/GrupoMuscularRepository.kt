package com.cibefit.backend.repositories

import com.cibefit.backend.models.GrupoMuscular
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GrupoMuscularRepository : JpaRepository<GrupoMuscular, Long> {

}