package com.zhuzichu.admin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.oas.annotations.EnableOpenApi
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
@EnableOpenApi
class Swagger3 {

    @Bean
    fun docket():Docket{
        return Docket(DocumentationType.OAS_30)
            .apiInfo(
                ApiInfoBuilder()
                    .contact(Contact("zhuzichu","","524787275@qq.com"))
                    .title("Nice-Admin")
                    .build()
            )
    }

}