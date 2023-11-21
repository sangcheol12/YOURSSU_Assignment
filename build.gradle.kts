import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("org.springframework.boot") version "2.7.16-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
    id("org.jlleitschuh.gradle.ktlint") version "11.6.0"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.6.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
val queryDslVersion = "5.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-core")
    implementation("jakarta.platform:jakarta.jakartaee-api:9.1.0")
    implementation("org.hibernate.validator:hibernate-validator:6.2.0.Final")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    // swagger
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")
    // QueryDSL
    implementation("com.querydsl:querydsl-jpa:$queryDslVersion")
    kapt("com.querydsl:querydsl-apt:$queryDslVersion:jpa")
    // h2 데이터베이스
    implementation("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
}

// QueryDSL
sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
    kotlin.srcDir("$buildDir/generated/source/kapt/main")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
