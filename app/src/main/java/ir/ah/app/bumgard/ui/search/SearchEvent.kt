package ir.ah.app.bumgard.ui.search

import ir.ah.app.bumgard.other.wrapper.*

sealed class SearchEvent {
    object SearchQueryIsEmpty : SearchEvent()
    object CheckOutDateIsEmpty : SearchEvent()
    object checkInDateIsEmpty : SearchEvent()

    data class ShowError(val failure: FailureInterface?) : SearchEvent()
}