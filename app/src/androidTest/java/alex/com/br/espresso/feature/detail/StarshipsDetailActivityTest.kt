package alex.com.br.espresso.feature.detail

import alex.com.br.espresso.features.detail.StarshipsDetailActivity
import alex.com.br.espresso.rule.KoinActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class StarshipsDetailActivityTest: KoinTest {

    @get:Rule
    val activityRule = KoinActivityTestRule(StarshipsDetailActivity::class.java)

    @Test
    fun shouldDisplayStarshipsDetail() {
        starshipsDetail {
            setUpShipDetailResponse(activityRule.mockWebServer)
            checkShipDetailResponse()
        }
    }
}