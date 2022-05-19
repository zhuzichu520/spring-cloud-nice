package com.zhuzichu.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApplicationGateway

fun main(args: Array<String>) {
    runApplication<ApplicationGateway>(*args)
}
