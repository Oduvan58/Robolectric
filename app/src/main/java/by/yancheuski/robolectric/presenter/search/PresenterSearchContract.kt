package by.yancheuski.robolectric.presenter.search

import by.yancheuski.robolectric.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)
}