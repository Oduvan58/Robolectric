package by.yancheuski.robolectric.view.details

import by.yancheuski.robolectric.view.ViewContract

internal interface ViewDetailsContract : ViewContract {
    fun setCount(count: Int)
}