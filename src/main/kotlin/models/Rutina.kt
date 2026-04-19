package com.cibefit.backend.models

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@Entity
@Table(name = "rutinas")
data class Rutina(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nombre: String = "",

    @ManyToOne
    @JoinColumn(name = "id_creador")
    @JsonIgnoreProperties("rutinas")
    val creador: Usuario? = null,

    @Column(name = "es_publica")
    val esPublica: Boolean = false
)