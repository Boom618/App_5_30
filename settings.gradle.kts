pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
//        maven {
//            url = uri("https://maven.aliyun.com/repository/google")
//        }
//        maven {
//            url = uri("https://maven.aliyun.com/repository/central")
//        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
//        maven {
//            url = uri("https://maven.aliyun.com/repository/google")
//        }
//        maven {
//            url = uri("https://maven.aliyun.com/repository/central")
//        }
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
