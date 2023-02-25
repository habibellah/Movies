package habibellah.ayata.domain.repositories

import habibellah.ayata.domain.entity.MovieDetailsResponse
import habibellah.ayata.domain.entity.MovieResponse
import retrofit2.Response

interface MovieRepository {
    suspend fun getMovieListByCategory(movieCategory : String) : Response<MovieResponse>
    suspend fun getTrendingMovieList() : Response<MovieResponse>
    suspend fun getOnTheAirTvList() : Response<MovieResponse>
    suspend fun getMovieDetails(movieId : Int) : Response<MovieDetailsResponse>
    suspend fun getPopularTvShow():Response<MovieResponse>
}