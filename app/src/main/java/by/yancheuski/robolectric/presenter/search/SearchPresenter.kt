package by.yancheuski.robolectric.presenter.search

import by.yancheuski.robolectric.model.SearchResponse
import by.yancheuski.robolectric.repository.GitHubRepository
import by.yancheuski.robolectric.view.search.ViewSearchContract
import retrofit2.Response

internal class SearchPresenter internal constructor(
    private val repository: GitHubRepository,
) : PresenterSearchContract, GitHubRepository.GitHubRepositoryCallback {

    private var viewContract: ViewSearchContract? = null

    override fun searchGitHub(searchQuery: String) {
        viewContract?.displayLoading(true)
        repository.searchGithub(searchQuery, this)
    }

    override fun handleGitHubResponse(response: Response<SearchResponse?>?) {
        viewContract?.displayLoading(false)
        if (response != null && response.isSuccessful) {
            val searchResponse = response.body()
            val searchResults = searchResponse?.searchResults
            val totalCount = searchResponse?.totalCount
            if (searchResults != null && totalCount != null) {
                viewContract?.displaySearchResults(
                    searchResults,
                    totalCount
                )
            } else {
                viewContract?.displayError("Search results or total count are null")
            }
        } else {
            viewContract?.displayError("Response is null or unsuccessful")
        }
    }

    override fun handleGitHubError() {
        viewContract?.displayLoading(false)
        viewContract?.displayError()
    }

    override fun onAttach(viewContract: ViewSearchContract) {
        this.viewContract = viewContract
    }

    override fun onDetach() {
        viewContract = null
    }
}