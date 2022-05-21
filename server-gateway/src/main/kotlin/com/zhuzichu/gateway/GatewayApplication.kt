package com.zhuzichu.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@SpringBootApplication
class GatewayApplication

fun main(args: Array<String>) {

    runApplication<GatewayApplication>(*args)
}
