package alex.com.br.espresso

interface BasePresenter<T> {

    fun stop()

    var view: T
}