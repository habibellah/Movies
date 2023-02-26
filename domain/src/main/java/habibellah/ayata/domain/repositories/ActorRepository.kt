package habibellah.ayata.domain.repositories

import habibellah.ayata.domain.entity.MovieActorsResponse
import habibellah.ayata.domain.entity.TvShowActorResponse
import retrofit2.Response

interface ActorRepository {
    suspend fun getMovieActorsList(filmId : Int) : Response<MovieActorsResponse>
    suspend fun getTvShowActorsList(filmId : Int) : Response<TvShowActorResponse>
}