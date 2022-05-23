import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.zhuzichu"
description = "共享库"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-reflect")
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    api("cn.hutool:hutool-all:5.8.1")
    api("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework:spring-web")
    implementation("org.springframework:spring-webmvc")
    implementation("com.baomidou:mybatis-plus-annotation:3.5.1")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.apache.tomcat.embed:tomcat-embed-core")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("io.swagger.core.v3:swagger-annotations:2.1.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}