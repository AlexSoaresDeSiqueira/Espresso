package alex.com.br.espresso

interface BaseView<out T : BasePresenter<*>> {

    val presenter: T

}