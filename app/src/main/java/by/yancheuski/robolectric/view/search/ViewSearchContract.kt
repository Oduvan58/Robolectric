package by.yancheuski.robolectric.view.search

import by.yancheuski.robolectric.model.SearchResult
import by.yancheuski.robolectric.view.ViewContract

internal interface ViewSearchContract : ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int,
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}