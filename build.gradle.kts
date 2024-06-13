plugins {
    id("java")
}

group = "ru.elenapltnkv"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation ("io.rest-assured:rest-assured:5.4.0")

}

tasks.test {
    useJUnitPlatform()
}