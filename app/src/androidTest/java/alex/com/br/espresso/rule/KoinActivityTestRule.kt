package alex.com.br.espresso.rule

import alex.com.br.espresso.di.*
import android.app.Activity
import android.support.test.rule.ActivityTestRule
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.ExternalResource
import org.junit.rules.RuleChain
import org.junit.rules.TestName
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin

class KoinActivityTestRule<T : Activity> constructor(
        activityClass: Class<T>,
        initialTouchMode: Boolean = true,
        launchActivity: Boolean = true
) : TestRule, KoinComponent {

    private val testName = TestName()
    val activityRule = ActivityTestRule<T>(activityClass, initialTouchMode, launchActivity)
    val mockWebServer = MockWebServer()

    private val delegateRule = RuleChain
            .outerRule(testName)
            .around(mockWebServer)
            .around(getKoinRule())
            .around(activityRule)

    override fun apply(base: Statement?, description: Description?): Statement {
        return delegateRule.apply(base, description)
    }

    private fun getKoinRule(): StartAndEndKoinRule {
        val baseUrl = mockWebServer.url("/").toString()
        return StartAndEndKoinRule(baseUrl)
    }

    inner class StartAndEndKoinRule(
            private val baseUrl: String
    ) : ExternalResource() {

        override fun before() {
            super.before()
            stopKoin()
            startKoin(listOf(networkModule,
                    repositoryModule,
                    presenterModule,
                    androidModule),
                    extraProperties = mapOf(PROPERTY_BASE_URL to baseUrl))
        }

        override fun after() {
            stopKoin()
            mockWebServer.shutdown()
            super.after()
        }
    }

}