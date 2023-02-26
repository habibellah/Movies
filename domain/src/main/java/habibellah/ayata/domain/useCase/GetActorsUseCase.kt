package habibellah.ayata.domain.useCase

import habibellah.ayata.domain.entity.MovieActorsResponse
import habibellah.ayata.domain.entity.TvShowActorResponse
import habibellah.ayata.domain.repositories.ActorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class GetActorsUseCase(private val actorRepository : ActorRepository) {
    suspend fun getMovieActorsList(filmId : Int) : Flow<MovieState<MovieActorsResponse?>> {
     return wrapWithFlow {
         actorRepository.getMovieActorsList(filmId)
     }
    }

    suspend fun getTvShowActorsList(filmId : Int) : Flow<MovieState<TvShowActorResponse?>> {
        return wrapWithFlow {
            actorRepository.getTvShowActorsList(filmId)
        }
    }

    private fun <T> wrapWithFlow(function : suspend () -> Response<T>) : Flow<MovieState<T?>> {
        return flow {
            emit(MovieState.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {
                    emit(MovieState.Success(result.body()))
                } else {
                    emit(MovieState.Error(result.message()))
                }
            } catch (e : Exception) {
                emit(MovieState.Error(e.message.toString()))
            }
        }
    }
}
