package habibellah.ayata.data.repositories

import habibellah.ayata.data.movieAppDataSource.remote.movieApi.MovieApi
import habibellah.ayata.domain.entity.MovieActorsResponse
import habibellah.ayata.domain.entity.TvShowActorResponse
import habibellah.ayata.domain.repositories.ActorRepository
import retrofit2.Response

class ActorRepositoryImpl(private val movieApi : MovieApi) : ActorRepository {
    override suspend fun getMovieActorsList(filmId : Int) : Response<MovieActorsResponse> {
        return movieApi.getMovieActors(filmId)
    }

    override suspend fun getTvShowActorsList(filmId : Int) : Response<TvShowActorResponse> {
        return movieApi.getTvShowActors(filmId)
    }
}