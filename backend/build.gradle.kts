plugins {
    id("org.springframework.boot") version "3.4.0-M1"
    id("io.spring.dependency-management") version "1.1.6"
    java
}

group = "com.fintrack.backend"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // Security + validation
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // JWT helper (Auth0)
    implementation("com.auth0:java-jwt:4.4.0")

    // JPA / DB (if not already present)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.h2database:h2")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
