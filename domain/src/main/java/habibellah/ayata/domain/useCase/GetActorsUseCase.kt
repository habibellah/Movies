package habibellah.ayata.domain.useCase

import habibellah.ayata.domain.entity.MovieActorsResponse
import habibellah.ayata.domain.entity.TvShowActorResponse
import habibellah.ayata.domain.repositories.ActorRepository
import habibellah.ayata.domain.useCase.Wrapper.wrapWithFlow
import kotlinx.coroutines.flow.Flow

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
}
