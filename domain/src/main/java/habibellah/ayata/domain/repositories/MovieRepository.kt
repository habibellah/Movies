package habibellah.ayata.domain.repositories

import habibellah.ayata.domain.entity.*
import retrofit2.Response

interface MovieRepository {
    suspend fun getMovieListByCategory(movieCategory : String) : Response<MovieResponse>
    suspend fun getTrendingMovieList() : Response<TvShowsResponse>
    suspend fun getOnTheAirTvList() : Response<MovieResponse>
    suspend fun getMovieDetails(movieId : Int) : Response<MovieDetailsResponse>
    suspend fun getTvShowDetails(tvShowId : Int) : Response<TvShowDetailsResponse>
    suspend fun getPopularTvShow(): Response<TvShowsResponse>
    suspend fun getSimilarMovies(movieId : Int):Response<SimilarMoviesResponse>
    suspend fun getSimilarTvShow(tvShowId : Int):Response<SimilarTvShowResponse>
    suspend fun getTvShowReview(tvShowId : Int):Response<TvShowReviewResponse>
    suspend fun getMovieReview(movieId : Int):Response<MovieReviewResponse>
}