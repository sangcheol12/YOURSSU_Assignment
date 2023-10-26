package com.example.ssu_blog.resolver

import com.example.ssu_blog.auth.AuthInfo
import org.apache.catalina.User
import org.springframework.core.MethodParameter
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class CustomHandlerMethodArgumentResolver: HandlerMethodArgumentResolver{
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.parameterType == AuthInfo::class.java
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        val authentication = SecurityContextHolder.getContext().authentication
        val currentPrincipal = authentication.principal

        if (currentPrincipal is UserDetails) {
            // UserDetails에서 사용자 정보 추출
            val userEmail = currentPrincipal.username

            // AuthInfo에 이메일 설정
            val curUser = AuthInfo(userEmail)
            return curUser
        }
        return null
    }
}