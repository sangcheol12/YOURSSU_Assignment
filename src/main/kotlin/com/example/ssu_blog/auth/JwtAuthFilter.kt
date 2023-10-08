package com.example.ssu_blog.auth

import org.springframework.core.annotation.Order
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Order(0)
@Component
class JwtAuthFilter(
    private val jwtTokenProvider: JwtTokenProvider,
) : OncePerRequestFilter() {
    private fun parseBearerToken(request: HttpServletRequest) = request.getHeader(HttpHeaders.AUTHORIZATION)
        .takeIf { it?.startsWith("Bearer ", true) ?: false }?.substring(7)

    // JWT 토큰을 검증하여 사용자 정보 추출
    private fun parseUserSpecification(token: String?) = (
            token?.takeIf { it.length >= 10 }
                ?.let { jwtTokenProvider.validateToken(it) }
                ?: "anonymous:anonymous"
            ).split(":")
        .let { User(it[0], "", listOf(SimpleGrantedAuthority(it[1]))) }

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val token = parseBearerToken(request)
        val user = parseUserSpecification(token)
        // 사용자 정보를 이용하여 인증 객체 생성
        UsernamePasswordAuthenticationToken.authenticated(user, token, user.authorities)
            .apply { details = WebAuthenticationDetails(request) }
            .also { SecurityContextHolder.getContext().authentication = it }

        filterChain.doFilter(request, response)
    }
}