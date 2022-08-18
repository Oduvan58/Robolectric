package by.yancheuski.robolectric.presenter.details

import by.yancheuski.robolectric.presenter.PresenterContract

internal interface PresenterDetailsContract : PresenterContract {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}