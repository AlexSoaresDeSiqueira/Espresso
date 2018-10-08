package alex.com.br.espresso

import alex.com.br.espresso.di.PROPERTY_BASE_URL
import alex.com.br.espresso.di.networkModule
import android.app.Application
import org.koin.android.ext.android.startKoin

class EspressoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin(
                this,
                listOf(networkModule),
                extraProperties = mapOf(PROPERTY_BASE_URL to BuildConfig.API)
        )
    }
}