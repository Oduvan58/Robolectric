package by.yancheuski.robolectric

import by.yancheuski.robolectric.presenter.search.SearchPresenter
import by.yancheuski.robolectric.repository.GitHubRepository
import by.yancheuski.robolectric.view.search.ViewSearchContract
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SearchPresenterTest {
    @Mock
    private lateinit var repository: GitHubRepository

    @Mock
    private lateinit var viewContract: ViewSearchContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun detailsPresenter_handleGitHubErrorWorking_ReturnsTrue() {
        val presenter = SearchPresenter(repository)
        presenter.onAttach(viewContract)
        presenter.handleGitHubError()
        verify(viewContract, times(1)).displayLoading(anyBoolean())
        verify(viewContract, times(1)).displayError()
        presenter.onDetach()
    }

    @Test
    fun detailsPresenter_handleGitHubErrorNotWorkingBeforeOnAttach_ReturnsTrue() {
        val presenter = SearchPresenter(repository)
        presenter.handleGitHubError()
        presenter.onAttach(viewContract)
        verify(viewContract, times(0)).displayLoading(anyBoolean())
        verify(viewContract, times(0)).displayError()
        presenter.onDetach()
    }

    @Test
    fun detailsPresenter_handleGitHubErrorNotWorkingBeforeOnDetach_ReturnsTrue() {
        val presenter = SearchPresenter(repository)
        presenter.onAttach(viewContract)
        presenter.onDetach()
        presenter.handleGitHubError()
        verify(viewContract, times(0)).displayLoading(anyBoolean())
        verify(viewContract, times(0)).displayError()
    }
}