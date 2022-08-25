package by.yancheuski.robolectric.presenter.details

import by.yancheuski.robolectric.presenter.PresenterContract
import by.yancheuski.robolectric.view.details.ViewDetailsContract

internal interface PresenterDetailsContract : PresenterContract<ViewDetailsContract> {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}