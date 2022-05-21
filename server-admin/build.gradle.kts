import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.zhuzichu"
description = "后台管理服务"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

extra["springCloudAlibabaVersion"] = "2021.0.1.0"

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.alibaba.cloud:spring-cloud-alibaba-sentinel-datasource")
//    implementation("com.alibaba.cloud:spring-cloud-alibaba-sentinel-gateway")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
//    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-seata")
//    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-sentinel")
//    implementation("com.alibaba.cloud:spring-cloud-starter-dubbo")
//    implementation("com.alibaba.cloud:spring-cloud-starter-stream-rocketmq")
//    implementation("com.alibaba.csp:sentinel-apache-dubbo-adapter")
//    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.1")
    api(project(path = ":library-shared"))
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

dependencyManagement {
    imports {
        mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
    }
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
