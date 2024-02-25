package di

private val sharedModules = listOf(getViewModelByPlatform())

fun getSharedModules() = sharedModules