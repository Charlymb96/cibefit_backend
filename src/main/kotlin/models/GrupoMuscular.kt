package com.cibefit.backend.models

import jakarta.persistence.*

@Entity
@Table(name = "grupos_musculares")
data class GrupoMuscular(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nombre: String = ""
)