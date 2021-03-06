package com.ecommerce.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    open fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.ecommerce.controller"))
        .paths(PathSelectors.any())
        .build()

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("Microservice with Spring Boot2.X and Kotlin")
            .description("Shopping Cart Demo")
            .version("1.0.0")
            .build()
    }
}