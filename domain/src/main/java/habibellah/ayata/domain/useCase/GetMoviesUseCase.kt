package habibellah.ayata.domain.useCase

import habibellah.ayata.domain.entity.MovieDetailsResponse
import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.entity.TvShowDetailsResponse
import habibellah.ayata.domain.entity.TvShowsResponse
import habibellah.ayata.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class GetMoviesUseCase(private val movieRepository : MovieRepository) {
    fun getMovieListByCategory(movieCategory : String) : Flow<MovieState<MovieResponse?>> {
        return wrapWithFlow {
            movieRepository.getMovieListByCategory(movieCategory = movieCategory)
        }
    }

    fun getTrendingMovieList() : Flow<MovieState<MovieResponse?>> {
        return wrapWithFlow {
            movieRepository.getTrendingMovieList()
        }
    }

    fun getOnTheAirTvList() : Flow<MovieState<MovieResponse?>> {
        return wrapWithFlow {
            movieRepository.getOnTheAirTvList()
        }
    }

    fun getMovieDetails(movieId : Int) : Flow<MovieState<MovieDetailsResponse?>> {
        return wrapWithFlow {
            movieRepository.getMovieDetails(movieId)
        }
    }

    fun getTvShowDetails(tvShowId : Int) : Flow<MovieState<TvShowDetailsResponse?>> {
        return wrapWithFlow {
            movieRepository.getTvShowDetails(tvShowId)
        }
    }

    suspend fun getPopularTvShow():Flow<MovieState<TvShowsResponse?>>{
        return wrapWithFlow {
            movieRepository.getPopularTvShow()
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