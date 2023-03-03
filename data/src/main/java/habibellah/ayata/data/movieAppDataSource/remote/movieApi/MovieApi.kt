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

    @GET("movie/{movieCategory}")
    suspend fun getMovieListByType(
        @Path(value = "movieCategory") movieCategory : String,
        @Query("page")
        page : Int ,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<MovieResponsePager>

    @GET("trending/tv/day?")
    suspend fun getTrendingMovieList(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<TvShowsResponse>

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
    ) : Response<TvShowDetailsResponse>

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
    ) : Response<TvShowsResponse>

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path(value = "movie_id") movieId : Int,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<SimilarMoviesResponse>

    @GET("tv/{tvShowId}/similar")
    suspend fun getSimilarTvShow(
        @Path(value = "tvShowId") tvShowId : Int,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<SimilarTvShowResponse>

    @GET("movie/{filmId}/credits")
    suspend fun getMovieActors(
        @Path(value = "filmId") filmId : Int,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<MovieActorsResponse>

    @GET("tv/{filmId}/credits")
    suspend fun getTvShowActors(
        @Path(value = "filmId") filmId : Int,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<TvShowActorResponse>

    @GET("tv/{movieId}/reviews")
    suspend fun getMovieReview(
        @Path(value = "movieId") movieId : Int,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<MovieReviewResponse>

    @GET("tv/{tvShowId}/reviews")
    suspend fun getTvShowReview(
        @Path(value = "tvShowId") tvShowId : Int,
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
    ) : Response<TvShowReviewResponse>
}