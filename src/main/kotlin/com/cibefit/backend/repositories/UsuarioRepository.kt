package com.cibefit.backend.repositories

import com.cibefit.backend.models.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {
    // Spring Data JPA lee el nombre de este método y crea el SELECT automáticamente:
    // "SELECT * FROM usuarios WHERE email = ?"
    fun findByEmail(email: String): Usuario?
}