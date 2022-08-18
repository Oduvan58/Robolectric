package by.yancheuski.robolectric.presenter

interface PresenterContract<ViewContract> {
    fun onAttach(viewContract: ViewContract)
    fun onDetach()
}