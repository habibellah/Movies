package habibellah.ayata.data.movieDataSource.remote.movieApi

import habibellah.ayata.data.BuildConfig
import habibellah.ayata.domain.entity.MovieDetailsResponse
import habibellah.ayata.domain.entity.MovieResponse
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

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path(value = "movieId") movieId : Int,
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ):Response<MovieDetailsResponse>

}