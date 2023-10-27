package com.example.ssu_blog.config

import com.example.ssu_blog.Exception.ExceptionResponse
import com.fasterxml.classmate.TypeResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.SecurityReference
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {
    @Bean
    fun swaggerAPI(): Docket {
        return Docket(DocumentationType.OAS_30)
            .additionalModels(TypeResolver().resolve(ExceptionResponse::class.java))// 에러 리스폰스 등록
            .useDefaultResponseMessages(false) // 기본 응답 메시지 표시 여부
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.ssu_blog")) // swagger 탐색 대상 패키지
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .securitySchemes(listOf(apiKey()))
            .securityContexts(listOf(securityContext()))
    }

    private fun apiInfo() = ApiInfoBuilder()
        .title("Yourssu Incubating")
        .description("Api Documentation")
        .version("1.0")
        .build()

    private fun apiKey(): ApiKey {
        return ApiKey("Authorization", "Authorization", "header")
    }

    fun securityContext(): SecurityContext {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .build()
    }

    fun defaultAuth(): List<SecurityReference> {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        return listOf(SecurityReference("Authorization", arrayOf(authorizationScope)))
    }
}
