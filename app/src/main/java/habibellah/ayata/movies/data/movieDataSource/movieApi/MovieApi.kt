package habibellah.ayata.movies.data.movieDataSource.movieApi

import habibellah.ayata.movies.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{movieCategory}")
    suspend fun getMoviesListByType(
        @Path(value = "movieCategory") movieCategory: String,
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): Response<MovieResponse>

    @GET("trending/all/day?")
    suspend fun getTrendingMovieList(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): Response<MovieResponse>

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTvList(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): Response<MovieResponse>
}