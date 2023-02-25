package habibellah.ayata.data.repositories

import habibellah.ayata.data.movieAppDataSource.remote.movieApi.MovieApi
import habibellah.ayata.domain.entity.MovieDetailsResponse
import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.entity.TvShowDetailsResponse
import habibellah.ayata.domain.entity.TvShowsResponse
import habibellah.ayata.domain.repositories.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(private val movieApi : MovieApi) :
    MovieRepository {
    override suspend fun getMovieListByCategory(movieCategory : String) =
        movieApi.getMovieListByCategory(movieCategory = movieCategory)

    override suspend fun getTrendingMovieList() : Response<MovieResponse> =
        movieApi.getTrendingMovieList()

    override suspend fun getOnTheAirTvList() : Response<MovieResponse> =
        movieApi.getOnTheAirTvList()

    override suspend fun getMovieDetails(movieId : Int) : Response<MovieDetailsResponse> =
        movieApi.getMovieDetails(movieId = movieId)

    override suspend fun getTvShowDetails(tvShowId : Int) : Response<TvShowDetailsResponse> = movieApi.getTvShowDetails(tvShowId)

    override suspend fun getPopularTvShow() : Response<TvShowsResponse> = movieApi.getPopularTvShow()
}
