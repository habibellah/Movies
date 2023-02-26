package habibellah.ayata.data.repositories

import habibellah.ayata.data.movieAppDataSource.remote.movieApi.MovieApi
import habibellah.ayata.domain.entity.ActorsResponse
import habibellah.ayata.domain.repositories.ActorRepository
import retrofit2.Response

class ActorRepositoryImpl(private val movieApi : MovieApi) : ActorRepository {
    override suspend fun getActorsList(id: Int)  : Response<ActorsResponse> {
      return movieApi.getActors(id)
    }
}