pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NewsApp"
include(":app")

include(":core:core-ui")
include(":core:core-network")
include(":core:core-database")
include(":core:core-common")

include(":domain:news")
include(":data:news")

include(":features:home")
include(":features:detail")
include(":features:search")
include(":features:bookmark")
