package habibellah.ayata.data.repositories

import habibellah.ayata.data.movieDataSource.remote.movieApi.MovieApi
import habibellah.ayata.domain.entity.MovieDetailsResponse
import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.repositories.MovieState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MovieRepositoryImpl(private val movieApi: MovieApi) :
  habibellah.ayata.domain.repositories.MovieRepository {
  override fun getMovieListByType(movieType: String): Flow<MovieState<MovieResponse?>> {
    return wrapWithFlow {
      movieApi.getMoviesListByType(movieCategory = movieType)
    }
  }

  override fun getTrendingMovieList(): Flow<MovieState<MovieResponse?>> {
    return wrapWithFlow {
      movieApi.getTrendingMovieList()
    }
  }

  override fun getOnTheAirTvList(): Flow<MovieState<MovieResponse?>> {
    return wrapWithFlow {
      movieApi.getOnTheAirTvList()
    }
  }

  override suspend fun getMovieDetails(movieId: Int): Flow<MovieState<MovieDetailsResponse?>> {
    return wrapWithFlow {
      movieApi.getMovieDetails(movieId)
    }
  }
}

fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<MovieState<T?>> {
  return flow {
    emit(MovieState.Loading)
    try {
      val result = function()
      if (result.isSuccessful) {
        emit(MovieState.Success(result.body()))
      } else {
        emit(MovieState.Error(result.message()))
      }
    } catch (e: Exception) {
      emit(MovieState.Error(e.message.toString()))
    }
  }
}
