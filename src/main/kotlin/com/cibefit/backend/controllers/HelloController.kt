package com.cibefit.backend.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/publico")
    fun hola(): String {
        return "¡El servidor de Cibefit está funcionando perfectamente!"
    }
}