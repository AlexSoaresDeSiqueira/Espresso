package alex.com.br.espresso.di

import alex.com.br.espresso.network.StarWarsAPI
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val PROPERTY_BASE_URL = "baseUrl"

val networkModule = module {

    single {
        OkHttpClient
                .Builder()
                .build()
    }

    single {
        val baseUrl = getProperty<String>(PROPERTY_BASE_URL)
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(baseUrl)
                .client(get())
                .build()
    }

    single {
        val retrofit: Retrofit = get()
        retrofit.create(StarWarsAPI::class.java)
    }
}