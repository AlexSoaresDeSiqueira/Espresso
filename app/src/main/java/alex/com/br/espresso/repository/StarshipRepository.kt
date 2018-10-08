package alex.com.br.espresso.repository

import alex.com.br.espresso.network.StarWarsAPI

class StarshipRepository(private var starWarsAPI: StarWarsAPI): StarshipRepositoryContract {

    override fun getStarshipDetail(starshipId: Int) =
            starWarsAPI.searchStarship(starshipId).execute()
}