package habibellah.ayata.domain.useCase


import habibellah.ayata.domain.entity.*
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

   suspend fun getMoviesByTypePager(movieCategory : String, page:Int): kotlin.Result<Flow<MovieState<MovieResponsePager?>>>{
       return wrapWithFlowPager {
           movieRepository.getMoviesByTypePager(movieCategory, page)
       }
    }

    fun getTrendingMovieList() : Flow<MovieState<TvShowsResponse?>> {
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

    suspend fun getPopularTvShow() : Flow<MovieState<TvShowsResponse?>> {
        return wrapWithFlow {
            movieRepository.getPopularTvShow()
        }
    }

    suspend fun getSimilarMovies(movieId : Int) : Flow<MovieState<SimilarMoviesResponse?>> {
        return wrapWithFlow {
            movieRepository.getSimilarMovies(movieId)
        }
    }

    suspend fun getSimilarTvShows(tvShowId : Int) : Flow<MovieState<SimilarTvShowResponse?>> {
        return wrapWithFlow {
            movieRepository.getSimilarTvShow(tvShowId)
        }
    }

    suspend fun getMovieReview(movieId : Int) : Flow<MovieState<MovieReviewResponse?>> {
        return wrapWithFlow {
            movieRepository.getMovieReview(movieId)
        }
    }

    suspend fun getTvShowReview(tvShowId : Int) : Flow<MovieState<TvShowReviewResponse?>> {
        return wrapWithFlow {
            movieRepository.getTvShowReview(tvShowId)
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

    private fun <T> wrapWithFlowPager(function : suspend () -> Response<T>) : kotlin.Result<Flow<MovieState<T?>>> {
        return kotlin.Result.success(flow {
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
        })
    }
}