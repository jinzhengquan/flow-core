import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    checkstyle
    jacoco
    id("org.springframework.boot") version "2.4.4"
}

group = "flow.core"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://mvnrepository.com/artifact/")
    maven("https://maven.aliyun.com/repository/public/")
    mavenCentral()
}

dependencies {
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springdoc:springdoc-openapi-ui:1.5.7")
    implementation("mysql:mysql-connector-java:5.1.47")
    implementation("org.flywaydb:flyway-core")
    implementation("org.projectlombok:lombok:1.18.20")
    implementation("org.hibernate:hibernate-core:5.4.4.Final")
    implementation("org.apache.commons:commons-pool2:2.9.0")
    implementation("org.projectlombok:lombok:1.18.18")
    implementation("org.mapstruct:mapstruct-jdk8:1.2.0.Final")
    implementation("com.graphql-java-kickstart:graphql-java-tools:5.4.0")
    implementation("com.graphql-java:graphql-spring-boot-starter:5.0.2")
    implementation("com.graphql-java:graphql-spring-boot-starter:5.0.2")

    annotationProcessor("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.2.0.Final")

    testImplementation(platform("org.junit:junit-bom:5.8.0-M1"))
    testImplementation(platform("org.testcontainers:testcontainers-bom:1.15.3"))
    testImplementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:mysql")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-junit-jupiter")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.20")
    testImplementation("io.rest-assured:rest-assured:4.0.0")
    testImplementation("org.testng:testng:7.1.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

checkstyle {
    maxWarnings = 0
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events("FAILED")
        }
    }

    jacocoTestReport {
        dependsOn(test)
    }
}

sourceSets {
    test {
        resources {
            srcDir(file("src/test/java"))
            exclude("*/.java")
        }
    }
}
