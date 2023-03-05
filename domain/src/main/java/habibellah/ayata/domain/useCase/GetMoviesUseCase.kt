package habibellah.ayata.domain.useCase


import habibellah.ayata.domain.entity.*
import habibellah.ayata.domain.repositories.MovieRepository
import habibellah.ayata.domain.useCase.Wrapper.wrapWithFlow
import habibellah.ayata.domain.useCase.Wrapper.wrapWithFlowPager
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(private val movieRepository : MovieRepository) {
    fun getMovieListByCategory(movieCategory : String) : Flow<MovieState<MovieResponse?>> {
        return wrapWithFlow {
            movieRepository.getMovieListByCategory(movieCategory = movieCategory)
        }
    }

   suspend fun getMoviesByTypePager(movieCategory : String, page:Int): kotlin.Result<Flow<MovieState<MovieResponse?>>>{
       return wrapWithFlowPager {
           movieRepository.getMoviesByTypePager(movieCategory, page)
       }
    }

    suspend fun getTrendingPager(page:Int): kotlin.Result<Flow<MovieState<MovieResponse?>>>{
        return wrapWithFlowPager {
            movieRepository.getTrendingPager(page)
        }
    }

    suspend fun getOnTheAirPager(page:Int): kotlin.Result<Flow<MovieState<TvShowsResponse?>>>{
        return wrapWithFlowPager {
            movieRepository.getOnTheAirPager( page)
        }
    }

    fun getTrendingMovieList() : Flow<MovieState<MovieResponse?>> {
        return wrapWithFlow {
            movieRepository.getTrendingMovieList()
        }
    }

    fun getOnTheAirTvList() : Flow<MovieState<TvShowsResponse?>> {
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
}