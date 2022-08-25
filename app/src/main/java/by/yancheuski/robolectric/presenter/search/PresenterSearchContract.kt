package by.yancheuski.robolectric.presenter.search

import by.yancheuski.robolectric.presenter.PresenterContract
import by.yancheuski.robolectric.view.search.ViewSearchContract

internal interface PresenterSearchContract : PresenterContract<ViewSearchContract> {
    fun searchGitHub(searchQuery: String)
}