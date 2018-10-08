package alex.com.br.espresso.feature.search

import alex.com.br.espresso.R
import alex.com.br.espresso.features.search.SearchStarshipsActivity
import alex.com.br.espresso.matchers.withTextError
import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchStarshipsActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(SearchStarshipsActivity::class.java)

    @Test
    fun shouldOpenScreenWithFields() {

        onView(withId(R.id.textViewNaveFavorita))
                .check(matches(withText(R.string.digite_sua_nave_favorita)))

        onView(withId(R.id.buttonSearch))
                .check(matches(isDisplayed()))

        onView(withId(R.id.editTextShip))
                .check(matches(withHint(R.string.ship)))
    }

    @Test
    fun shouldShowErrorMessage() {

        onView(withId(R.id.buttonSearch))
                .perform(click())

        onView(withId(R.id.textInputLayoutShip))
                .check(matches(withTextError("Campo obrigatório")))
    }

    @Test
    fun shouldSearchShip() {

        onView(withId(R.id.editTextShip))
                .perform(typeText("DeathStar"))

        closeSoftKeyboard()

        onView(withId(R.id.buttonSearch))
                .perform(click())
    }
}