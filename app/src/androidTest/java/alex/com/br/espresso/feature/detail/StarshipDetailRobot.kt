package alex.com.br.espresso.feature.detail

import alex.com.br.espresso.R
import alex.com.br.espresso.response.GETSTARSHIPSDETAIL
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

fun StarshipsDetailActivityTest.starshipsDetail(
        block: StarshipDetailRobot.() -> Unit
) = StarshipDetailRobot().apply {
    block()
}

class StarshipDetailRobot {

    fun nomeTextView() = R.id.textViewValueNome
    fun fabricanteTextView() = R.id.textViewValueFabricante
    fun modeloTextView() = R.id.textViewValueModelo

    fun checkShipDetailResponse() {
        onView(withId(nomeTextView()))
                .check(matches(withText("Death Star")))

        onView(withId(fabricanteTextView()))
                .check(matches(withText("Imperial Department of Military Research, Sienar Fleet Systems")))

        onView(withId(modeloTextView()))
                .check(matches(withText("DS-1 Orbital Battle Station")))
    }

    fun setUpShipDetailResponse(mockWebServer: MockWebServer) {
        mockWebServer
                .enqueue(
                        MockResponse().setBody(GETSTARSHIPSDETAIL)
                )
    }
}