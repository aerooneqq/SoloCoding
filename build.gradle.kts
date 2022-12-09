plugins {
  id("java")
  id("org.jetbrains.kotlin.jvm") version "1.5.10"
  id("org.jetbrains.intellij") version "1.4.0"
}

group = "com.soloCoding"
version = "1.0.1"

repositories {
  mavenCentral()
}

intellij {
  version.set("2022.3")
  type.set("IC")
}

tasks {
  withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
  }

  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
  }

  signPlugin {
    certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
    privateKey.set(System.getenv("PRIVATE_KEY"))
    password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
  }

  buildSearchableOptions {
    enabled = false
  }

  publishPlugin {
    token.set(System.getenv("PUBLISH_TOKEN"))
  }
}
