package com.zhuzichu.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import springfox.documentation.oas.annotations.EnableOpenApi


@EnableDiscoveryClient
@SpringBootApplication
@EnableOpenApi
class AdminApplication
fun main(args: Array<String>) {
    runApplication<AdminApplication>(*args)
}
