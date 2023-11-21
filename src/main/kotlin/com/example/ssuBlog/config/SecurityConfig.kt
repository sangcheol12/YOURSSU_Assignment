package com.example.ssuBlog.config

import com.example.ssuBlog.auth.ExceptionHandlerFilter
import com.example.ssuBlog.auth.JwtAuthFilter
import com.example.ssuBlog.auth.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val exceptionHandlerFilter: ExceptionHandlerFilter
) {
    private val allowedUrls = arrayOf("/", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/**", "/api/user/signup", "/api/user/signin", "/api/user/refresh", "/api/user/test")

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        val requestMatchers = allowedUrls.map { AntPathRequestMatcher(it) }.toTypedArray()
        return WebSecurityCustomizer { web -> web.ignoring().requestMatchers(*requestMatchers) }
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests()
            // .antMatchers(*allowedUrls).permitAll() // 허용할 URL 목록
            .anyRequest().authenticated() // 나머지는 인증 필요
            .and()
            .addFilterBefore(JwtAuthFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java) // JwtAuthFilter 추가
            .addFilterBefore(exceptionHandlerFilter, JwtAuthFilter::class.java)
            .csrf().disable()
        return http.build()
    }
}
