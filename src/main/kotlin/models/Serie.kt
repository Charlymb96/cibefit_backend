package com.cibefit.backend.models

import jakarta.persistence.*

@Entity
@Table(name = "series")
data class Serie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "id_sesion")
    val sesion: Sesion,

    @ManyToOne
    @JoinColumn(name = "id_ejercicio")
    val ejercicio: Ejercicio,

    @Column(nullable = false)
    val kilos: Double,

    @Column(nullable = false)
    val reps: Int
)