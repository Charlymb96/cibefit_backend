package com.cibefit.backend.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
@Table(name = "ejercicios")
data class Ejercicio(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nombre: String = "",

    @Column(columnDefinition = "TEXT")
    val descripcion: String? = null,

    @Column(name = "imagen_url")
    val imagenUrl: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_muscular")
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    val grupoMuscular: GrupoMuscular? = null
)