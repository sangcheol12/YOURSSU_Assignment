package com.example.ssu_blog.auth

import com.example.ssu_blog.Exception.BadRequestCode
import com.example.ssu_blog.Exception.CustomBadRequestException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

//@Component
class JwtAuthFilter(
    private val jwtTokenProvider: JwtTokenProvider,
) : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val accessToken = jwtTokenProvider.getAccessToken(request)
        if(accessToken != null) {
            if(jwtTokenProvider.validateAccessToken(accessToken)) setAuthentication(accessToken, request)
            else throw CustomBadRequestException(BadRequestCode.INVALID_TOKEN) // 유효하지 않는 토큰

        } else {
            throw CustomBadRequestException(BadRequestCode.EMPTY_TOKEN) // 토큰이 존재하지 않음
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