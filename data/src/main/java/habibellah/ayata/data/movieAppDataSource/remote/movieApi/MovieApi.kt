package habibellah.ayata.data.movieAppDataSource.remote.movieApi

import habibellah.ayata.data.BuildConfig
import habibellah.ayata.domain.entity.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/{movieCategory}")
    suspend fun getMovieListByCategory(
        @Path(value = "movieCategory") movieCategory : String,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<MovieResponse>

    @GET("trending/all/day?")
    suspend fun getTrendingMovieList(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<MovieResponse>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path(value = "movieId") movieId : Int,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<MovieDetailsResponse>

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTvList(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<MovieResponse>

    @GET("tv/{tvId}")
    suspend fun getTvShowDetails(
        @Path(value = "tvId") tvId : Int,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<MovieDetailsResponse>

    @GET("authentication/token/new")
    suspend fun getRequestToken(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<RequestToken>

    @POST("authentication/token/validate_with_login")
    suspend fun checkLoginInformation(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
        @Body userInformation : CheckLoginBody
    ) : Response<AuthenticationTokenResponse>

    @GET("authentication/session/new")
    suspend fun getSessionId(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
        @Query("request_token") tokenRequest : String
    ) : Response<SessionIdResponse>

    @GET("account")
    suspend fun getAccountId(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
        @Query("session_id") session_id : String
    ) : Response<AccountResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShow(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<MovieResponse>

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path(value = "movie_id") movieId : Int,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<SimilarMoviesResponse>
}