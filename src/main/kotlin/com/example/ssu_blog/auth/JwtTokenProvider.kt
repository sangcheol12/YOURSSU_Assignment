package com.example.ssu_blog.auth

import com.example.ssu_blog.adapter.out.persistence.repository.UserRepository
import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*
import javax.crypto.spec.SecretKeySpec
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

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
    private val userRepository: UserRepository
) {
    fun createAccessToken(email: String, role: String): String { return createToken(email, role, accessTokenKey, accessTokenExpirationHours) }
    fun createRefreshToken(email: String, role: String): String { return createToken(email, role, refreshTokenKey, refreshTokenExpirationHours) }
    fun createToken(email: String, role: String, tokenKey: String, expirationHours: Long) : String {
        val claims: Claims = Jwts.claims().setSubject(email); // claims 생성 및 payload 설정
        claims.put("role", role); // 권한 설정, key/ value 쌍으로 저장
        //val date = Date()
        return Jwts.builder()
            .signWith(SecretKeySpec(tokenKey.toByteArray(), SignatureAlgorithm.HS512.jcaName)) // HS512 알고리즘을 사용하여 secretKey를 이용해 서명
            .setClaims(claims)   // JWT 토큰 제목
            .setIssuer(issuer)    // JWT 토큰 발급자
            .setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))    // JWT 토큰 발급 시간
            .setExpiration(Date.from(Instant.now().plus(expirationHours, ChronoUnit.HOURS)))    // JWT 토큰의 만료시간 설정
            //.setExpiration(Date(date.time + expirationHours))
            .compact()!!
    }    // JWT 토큰 생성

    fun getAccessToken(request: HttpServletRequest) = request.getHeader("Authorization")
        ?.takeIf { it.startsWith("Bearer ", ignoreCase = true) }
        ?.substring(7)?.takeIf { it.isNotEmpty() }

    fun getRefreshToken(request: HttpServletRequest) = request.getHeader("RefreshToken")
        ?.takeIf { it.startsWith("Bearer ", ignoreCase = true) }
        ?.substring(7)?.takeIf { it.isNotEmpty() }

    // JWT 토큰을 검증하여 사용자 정보 추출
    fun getAuthentication(token: String) = User(getUserEmail(token), "", getRole(token))

    fun getUserEmail(token: String): String {
        return Jwts.parser().setSigningKey(accessTokenKey.toByteArray()).parseClaimsJws(token).body.subject
    }

    fun getUserEmailByRefresh(token: String): String {
        return Jwts.parser().setSigningKey(refreshTokenKey.toByteArray()).parseClaimsJws(token).body.subject
    }

    fun getRole(token: String): MutableCollection<out GrantedAuthority>? {
        val claims = Jwts.parser().setSigningKey(accessTokenKey.toByteArray()).parseClaimsJws(token).body
        val role = claims["role"] as String
        return mutableListOf(SimpleGrantedAuthority(role))
    }

    fun getRoleByRefresh(token: String): String {
        val claims = Jwts.parser().setSigningKey(refreshTokenKey.toByteArray()).parseClaimsJws(token).body
        return claims["role"] as String
    }

    fun validateAccessToken(token: String): Boolean {
        return validateToken(token, accessTokenKey)
    }

    fun validateRefreshToken(token: String): Boolean {
        return validateToken(token, refreshTokenKey)
    }

    // 토큰의 유효성 + 만료일자 확인
    fun validateToken(jwtToken: String, secretKey: String): Boolean {
        try {
            val claims: Jws<Claims> = Jwts.parser().setSigningKey(secretKey.toByteArray()).parseClaimsJws(jwtToken)
            return !claims.body.expiration.before(Date())
        } catch (e: ExpiredJwtException) {
            return false
        }
    }

    // 어세스 토큰 헤더 설정
    fun setHeaderAccessToken(response: HttpServletResponse, accessToken: String) {
        response.setHeader("authorization", "Bearer $accessToken")
    }

    // 리프레시 토큰 헤더 설정
    fun setHeaderRefreshToken(response: HttpServletResponse, refreshToken: String) {
        response.setHeader("refreshToken", "Bearer $refreshToken")
    }

    fun compareRefreshToken(token: String): Boolean {
        val email = getUserEmailByRefresh(token)
        return token == userRepository.findByEmail(email)?.refreshToken
    }
}