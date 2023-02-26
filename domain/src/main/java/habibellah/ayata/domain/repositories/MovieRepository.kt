package habibellah.ayata.domain.repositories

import habibellah.ayata.domain.entity.MovieDetailsResponse
import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.entity.TvShowDetailsResponse
import habibellah.ayata.domain.entity.TvShowsResponse
import retrofit2.Response

interface MovieRepository {
    suspend fun getMovieListByCategory(movieCategory : String) : Response<MovieResponse>
    suspend fun getTrendingMovieList() : Response<TvShowsResponse>
    suspend fun getOnTheAirTvList() : Response<MovieResponse>
    suspend fun getMovieDetails(movieId : Int) : Response<MovieDetailsResponse>
    suspend fun getTvShowDetails(tvShowId : Int) : Response<TvShowDetailsResponse>
    suspend fun getPopularTvShow(): Response<TvShowsResponse>
}