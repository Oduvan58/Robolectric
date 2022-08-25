package by.yancheuski.robolectric.presenter

import by.yancheuski.robolectric.repository.RepositoryCallback

internal interface RepositoryContract {
    fun searchGithub(
        query: String,
        callback: RepositoryCallback,
    )
}