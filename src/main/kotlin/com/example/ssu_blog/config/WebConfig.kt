package com.example.ssu_blog.config

import com.example.ssu_blog.resolver.CustomHandlerMethodArgumentResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig @Autowired constructor(private val customHandlerMethodArgumentResolver: CustomHandlerMethodArgumentResolver) : WebMvcConfigurer {

    override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
        argumentResolvers.add(customHandlerMethodArgumentResolver)
    }
}