package alex.com.br.espresso.network

import alex.com.br.espresso.network.model.Starship
import retrofit2.http.GET

interface StarWarsAPI {

    @GET("starships/9/")
    fun searchStarship(): Starship
}