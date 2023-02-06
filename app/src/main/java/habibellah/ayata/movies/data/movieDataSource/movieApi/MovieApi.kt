package habibellah.ayata.movies.data.movieDataSource.movieApi

import habibellah.ayata.movies.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{movie_type}")
   suspend fun getMoviesListByType(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY,
        @Path("movie_type") movieType : String
    ) : Response<MovieResponse>
}