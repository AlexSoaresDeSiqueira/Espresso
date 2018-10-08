package alex.com.br.espresso.feature.search

import alex.com.br.espresso.R
import alex.com.br.espresso.matchers.withTextError
import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*

fun SearchStarshipsActivityTest.searchStarships(
        block: SearchStarshipsRobot.() -> Unit
) = SearchStarshipsRobot().apply {
    block()
}

class SearchStarshipsRobot {

    private fun shipEditText() = R.id.editTextShip
    private fun searchButton() = R.id.buttonSearch
    private fun shipInputLayout() = R.id.textInputLayoutShip
    private fun naveFavoritaTextView() = R.id.textViewNaveFavorita

    fun typeShip(text: String) {
        onView(withId(shipEditText()))
                .perform(typeText(text))
        closeSoftKeyboard()
    }

    fun clickSearchButton() {
        onView(withId(searchButton()))
                .perform(click())
    }

    fun checkErrorInputLayoutShip(errorToCheck: String) {
        onView(withId(shipInputLayout()))
                .check(matches(withTextError(errorToCheck)))
    }

    fun checkSearchActivityInitialState() {

        onView(withId(naveFavoritaTextView()))
                .check(matches(withText(R.string.digite_sua_nave_favorita)))

        onView(withId(searchButton()))
                .check(matches(isDisplayed()))

        onView(withId(shipEditText()))
                .check(matches(withHint(R.string.ship)))
    }
}