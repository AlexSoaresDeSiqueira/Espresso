package alex.com.br.espresso.features.detail

import alex.com.br.espresso.BasePresenter
import alex.com.br.espresso.BaseView

interface StarshipsDetailContract {

    interface View: BaseView<Presenter> {
        fun updateView(
                nome: String,
                modelo: String,
                fabricante: String
        )
    }

    interface Presenter: BasePresenter<View> {
        fun getStarshipDetail(starshipId: Int)
    }
}