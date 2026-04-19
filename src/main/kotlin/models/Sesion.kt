package com.cibefit.backend.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "sesiones")
data class Sesion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    val usuario: Usuario,

    @ManyToOne
    @JoinColumn(name = "id_rutina")
    val rutina: Rutina,

    @Column(nullable = false)
    val fecha: LocalDateTime = LocalDateTime.now()
)