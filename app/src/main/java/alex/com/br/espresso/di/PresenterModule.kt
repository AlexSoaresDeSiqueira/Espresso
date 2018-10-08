package alex.com.br.espresso.di

import alex.com.br.espresso.features.detail.StarshipsDetailContract
import alex.com.br.espresso.features.detail.StarshipsDetailPresenter
import org.koin.dsl.module.module

val presenterModule = module {

    factory { (view: StarshipsDetailContract.View) -> StarshipsDetailPresenter(view, get(), get()) as StarshipsDetailContract.Presenter }
}
