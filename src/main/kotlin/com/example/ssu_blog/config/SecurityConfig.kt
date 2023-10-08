package com.example.ssu_blog.config

import com.example.ssu_blog.auth.JwtAuthFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableMethodSecurity
class SecurityConfig(
    private val jwtAuthFilter: JwtAuthFilter,
) {
    private val allowedUrls = arrayOf("/", "/swagger-ui/**", "/v3/**", "/api/user/signup", "/api/user/signin")

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests()
            .antMatchers(*allowedUrls).permitAll() // 허용할 URL 목록
            .anyRequest().authenticated() // 나머지는 인증 필요
            .and()
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java) // JwtAuthFilter 추가
            .csrf().disable()
        return http.build()
    }
}