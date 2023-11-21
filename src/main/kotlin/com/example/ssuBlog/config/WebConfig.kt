package com.example.ssuBlog.config

import com.example.ssuBlog.resolver.CustomHandlerMethodArgumentResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig @Autowired constructor(
    private val customHandlerMethodArgumentResolver: CustomHandlerMethodArgumentResolver
) : WebMvcConfigurer {

    override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
        argumentResolvers.add(customHandlerMethodArgumentResolver)
    }
}
