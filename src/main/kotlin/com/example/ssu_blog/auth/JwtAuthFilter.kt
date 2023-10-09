package com.example.ssu_blog.auth

import org.springframework.core.annotation.Order
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthFilter(
    private val jwtTokenProvider: JwtTokenProvider,
) : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val accessToken = jwtTokenProvider.getAccessToken(request)
        val refreshToken = jwtTokenProvider.getRefreshToken(request)
        if(accessToken != null) {
            if(jwtTokenProvider.validateAccessToken(accessToken)) setAuthentication(accessToken, request)
            else if(refreshToken != null) {
                if(jwtTokenProvider.validateRefreshToken(refreshToken) && jwtTokenProvider.compareRefreshToken(refreshToken)) {
                    val email = jwtTokenProvider.getUserEmailByRefresh(refreshToken)
                    val role = jwtTokenProvider.getRoleByRefresh(refreshToken)
                    val newAccessToken = jwtTokenProvider.createAccessToken(email, role)
                    jwtTokenProvider.setHeaderAccessToken(response, newAccessToken)
                    setAuthentication(newAccessToken, request)
                }
            }
        }
        filterChain.doFilter(request, response)
    }

    fun setAuthentication(token: String, request: HttpServletRequest) {
        val user = jwtTokenProvider.getAuthentication(token) // 사용자 정보를 이용하여 인증 객체 생성
        UsernamePasswordAuthenticationToken.authenticated(user, token, user.authorities) // 토큰의 인증 여부 확인
            .apply { details = WebAuthenticationDetails(request) }
            .also { SecurityContextHolder.getContext().authentication = it } // SecurityContext 사용자 저장
    }
}