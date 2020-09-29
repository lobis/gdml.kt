plugins {
    val toolsVersion = "0.6.1-dev-1.4.20-M1"
    id("ru.mipt.npm.project") version toolsVersion
    id("ru.mipt.npm.mpp") version toolsVersion
    id("ru.mipt.npm.publish") version toolsVersion
}

group = "ru.mipt.npm"
version = "0.2.1"

kscience {
    useSerialization {
        xml()
    }
}

repositories {
    mavenLocal()
}

ksciencePublish {
    githubProject = "gdml.kt"
    bintrayRepo = "kscience"
}

val bintrayRepo by extra("kscience")
val githubProject by extra("gdml.kt")

kotlin {
    js {
        browser {
            testTask {
                useKarma {
                    useChrome()
                }
            }
        }
    }

    sourceSets {
        commonMain {
            dependencies {
//                api(kotlin("reflect"))
            }
        }

        jvmMain {
            dependencies {
                api("com.fasterxml.woodstox:woodstox-core:5.0.3")
            }
        }
    }
}