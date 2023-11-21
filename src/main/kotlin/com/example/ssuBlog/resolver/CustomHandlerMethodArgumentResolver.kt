package com.example.ssuBlog.resolver

import com.example.ssuBlog.auth.AuthInfo
import com.example.ssuBlog.auth.JwtTokenProvider
import org.springframework.core.MethodParameter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class CustomHandlerMethodArgumentResolver(
    private val jwtTokenProvider: JwtTokenProvider
) : HandlerMethodArgumentResolver {
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
            // access token 추출
            val token = authentication.credentials as String

            // UserDetails에서 사용자 정보 추출
            val userEmail = currentPrincipal.username
            val role: String? = (
                jwtTokenProvider
                    .getRole(token) as? MutableCollection<out GrantedAuthority>
                )
                ?.firstOrNull()?.authority

            // AuthInfo에 이메일 설정
            val curUser = AuthInfo(userEmail, role!!)
            return curUser
        }
        return null
    }
}
