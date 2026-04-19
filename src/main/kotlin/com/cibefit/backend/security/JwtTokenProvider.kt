package com.cibefit.backend.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtTokenProvider {

    // La clave debe tener al menos 32 caracteres (256 bits) para HS256
    private val key: SecretKey = Keys.hmacShaKeyFor("esta-clave-debe-ser-muy-larga-y-secreta-cibefit-2026-tfg".toByteArray())

    fun generateToken(authentication: Authentication): String {
        val userPrincipal = authentication.name
        val now = Date()
        val expiryDate = Date(now.time + 3600000) // 1 hora

        return Jwts.builder()
            .setSubject(userPrincipal)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    fun getEmailFromToken(token: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }

    fun validateToken(token: String): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            return true
        } catch (ex: Exception) {
            return false
        }
    }
}