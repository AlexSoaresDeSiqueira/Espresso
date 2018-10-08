package alex.com.br.espresso.features.detail

import alex.com.br.espresso.repository.StarshipRepositoryContract
import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class StarshipsDetailPresenter(override var view: StarshipsDetailContract.View,
                               private val repository: StarshipRepositoryContract,
                               private val executor: Executor) : StarshipsDetailContract.Presenter {

    override fun getStarshipDetail(starshipId: Int) {
        executor.execute {
            val response = repository.getStarshipDetail(starshipId)

            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    Handler(Looper.getMainLooper()).post {
                        view.updateView(
                                it.name,
                                it.model,
                                it.manufacturer)
                    }
                }
            }
        }
    }

    override fun stop() {

    }

}