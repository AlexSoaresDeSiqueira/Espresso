package alex.com.br.espresso.di

import org.koin.dsl.module.module
import java.util.concurrent.Executor
import java.util.concurrent.Executors

val androidModule = module {
    single { Executors.newSingleThreadExecutor() as Executor }
}