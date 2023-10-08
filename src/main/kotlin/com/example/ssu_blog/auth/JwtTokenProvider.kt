package com.example.ssu_blog.auth

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*
import javax.crypto.spec.SecretKeySpec
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException

@Component
class JwtTokenProvider(
    @Value("\${accessTokenKey}")
    private val accessTokenKey: String,
    @Value("\${refreshTokenKey}")
    private val refreshTokenKey: String,
    @Value("\${accessTokenExpirationHours}")
    private val accessTokenExpirationHours: Long,
    @Value("\${refreshTokenExpirationHours}")
    private val refreshTokenExpirationHours: Long,
    @Value("\${issuer}")
    private val issuer: String,
) {
    fun createAccessToken(userSpecification: String): String { return createToken(userSpecification, accessTokenKey, accessTokenExpirationHours) }
    fun createRefreshToken(userSpecification: String): String { return createToken(userSpecification, refreshTokenKey, refreshTokenExpirationHours) }
    fun createToken(userSpecification: String, tokenKey: String, expirationHours: Long) = Jwts.builder()
        .signWith(SecretKeySpec(tokenKey.toByteArray(), SignatureAlgorithm.HS512.jcaName)) // HS512 알고리즘을 사용하여 secretKey를 이용해 서명
        .setSubject(userSpecification)   // JWT 토큰 제목
        .setIssuer(issuer)    // JWT 토큰 발급자
        .setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))    // JWT 토큰 발급 시간
        .setExpiration(Date.from(Instant.now().plus(expirationHours, ChronoUnit.HOURS)))    // JWT 토큰의 만료시간 설정
        .compact()!!    // JWT 토큰 생성

    fun validateToken(token: String): String? {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(accessTokenKey.toByteArray())
                .build()
                .parseClaimsJws(token)
                .body
                .subject
        } catch (e: ExpiredJwtException) {
            throw IllegalArgumentException("AccessToken이 만료되었습니다.")
        }
    }
}


