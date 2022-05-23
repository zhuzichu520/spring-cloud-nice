package com.zhuzichu.system.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.Contact
import springfox.documentation.service.SecurityReference
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class Swagger3 {

    @Bean
    fun docket(): Docket {
        return Docket(DocumentationType.OAS_30)
            .apiInfo(
                ApiInfoBuilder()
                    .title("接口文档")
                    .description("接口文档")
                    .version("1.0")
                    .contact(Contact("会磨刀的小猪", "", "524787275@qq.com"))
                    .build()
            )
            .enable(true)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/error").negate())
            .paths(PathSelectors.any())
            .build().apply {
                securitySchemes(listOf(
                    ApiKey("token", "token", "header")
                ))
                securityContexts(listOf(
                    SecurityContext.builder().securityReferences(listOf(SecurityReference("token",
                        arrayOf(AuthorizationScope("global", "accessEverything"))))).build()
                ))
            }
    }

}