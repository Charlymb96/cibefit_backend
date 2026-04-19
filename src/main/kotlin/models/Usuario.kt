package com.cibefit.backend.models

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

// 1. Definimos el Enum primero o después de la clase
enum class RolUsuario {
    USER, ADMIN
}


@Entity
@Table(name = "usuarios")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, unique = true, length = 50)
    var username: String = "",

    @Column(nullable = false, unique = true, length = 100)
    var email: String = "",

    @Column(nullable = false)
    var password: String = "",

    var peso: Double? = null,
    var altura: Int? = null,

    @Enumerated(EnumType.STRING)
    var rol: RolUsuario = RolUsuario.USER,

    @OneToMany(mappedBy = "creador", cascade = [CascadeType.ALL])
    @JsonIgnoreProperties("creador") // Esto evita el bucle infinito al convertir a JSON
    var rutinas: MutableList<Rutina> = mutableListOf()
)