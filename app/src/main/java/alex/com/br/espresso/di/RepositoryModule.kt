package alex.com.br.espresso.di

import alex.com.br.espresso.repository.StarshipRepository
import alex.com.br.espresso.repository.StarshipRepositoryContract
import org.koin.dsl.module.module

val repositoryModule = module {

    single { StarshipRepository(get()) as StarshipRepositoryContract }
}