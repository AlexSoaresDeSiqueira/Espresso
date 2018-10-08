package alex.com.br.espresso.feature.search

import alex.com.br.espresso.features.search.SearchStarshipsActivity
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
        searchStarships {
            checkSearchActivityInitialState()
        }
    }

    @Test
    fun shouldShowErrorMessage() {
        searchStarships {
            clickSearchButton()
            checkErrorInputLayoutShip("Campo obrigatório")
        }
    }

    @Test
    fun shouldSearchShip() {
        searchStarships {
            typeShip("DeathStar")
            clickSearchButton()
        }
    }
}