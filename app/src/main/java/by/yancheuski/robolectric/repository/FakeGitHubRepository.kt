package by.yancheuski.robolectric.repository

import by.yancheuski.robolectric.model.SearchResponse
import by.yancheuski.robolectric.presenter.RepositoryContract
import retrofit2.Response

internal class FakeGitHubRepository : RepositoryContract {

    override fun searchGithub(
        query: String,
        callback: RepositoryCallback,
    ) {
        callback.handleGitHubResponse(Response.success(SearchResponse(42, listOf())))
    }
}