package com.zhuzichu.gateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GatewayConfig {

//    @Bean
    fun routeLocator(routeLocatorBuilder: RouteLocatorBuilder) : RouteLocator{
        return routeLocatorBuilder.routes().apply {
            route("admin") {
                it.path("/admin/*").uri("lb://server-admin")
            }
        }.build()
    }

}