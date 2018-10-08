package alex.com.br.espresso.repository

import alex.com.br.espresso.network.model.Starship
import retrofit2.Response

interface StarshipRepositoryContract {

    fun getStarshipDetail(starshipId: Int): Response<Starship>
}