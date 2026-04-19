package com.cibefit.backend.models

import jakarta.persistence.*

@Entity
@Table(name = "rutina_ejercicio")
data class RutinaEjercicio(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "id_rutina")
    var rutina: Rutina? = null,

    @ManyToOne
    @JoinColumn(name = "id_ejercicio")
    var ejercicio: Ejercicio? = null,

    @Column(nullable = false)
    var orden: Int = 0
)