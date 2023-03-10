package habibellah.ayata.data.repositories

import habibellah.ayata.data.movieAppDataSource.remote.movieApi.MovieApi
import habibellah.ayata.domain.entity.*
import habibellah.ayata.domain.repositories.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(private val movieApi : MovieApi) :
    MovieRepository {
    override suspend fun getMovieListByCategory(movieCategory : String) =
        movieApi.getMovieListByCategory(movieCategory = movieCategory)

    override suspend fun getTrendingMovieList() : Response<MovieResponse> =
        movieApi.getTrendingMovieList()

    override suspend fun getOnTheAirTvList() : Response<TvShowsResponse> =
        movieApi.getOnTheAirTvList()

    override suspend fun getMovieDetails(movieId : Int) : Response<MovieDetailsResponse> =
        movieApi.getMovieDetails(movieId = movieId)

    override suspend fun getTvShowDetails(tvShowId : Int) : Response<TvShowDetailsResponse> =
        movieApi.getTvShowDetails(tvShowId)

    override suspend fun getPopularTvShow() : Response<TvShowsResponse> =
        movieApi.getPopularTvShow()

    override suspend fun getSimilarMovies(movieId : Int) : Response<SimilarMoviesResponse> =
        movieApi.getSimilarMovies(movieId)

    override suspend fun getSimilarTvShow(tvShowId : Int) : Response<SimilarTvShowResponse> =
        movieApi.getSimilarTvShow(tvShowId)

    override suspend fun getTvShowReview(tvShowId : Int) : Response<TvShowReviewResponse> =
        movieApi.getTvShowReview(tvShowId)

    override suspend fun getMovieReview(movieId : Int) : Response<MovieReviewResponse> =
        movieApi.getMovieReview(movieId)

    override suspend fun getMoviesByTypePager(
        movieCategory : String,
        page : Int
    ) : Response<MovieResponse> {
        return movieApi.getMovieListByCategory(page = page, movieCategory = movieCategory)
    }

    override suspend fun getTrendingPager(
        page : Int
    ) : Response<MovieResponse> {
        return movieApi.getTrendingMovieList(page = page)
    }

    override suspend fun getOnTheAirPager(
        page : Int
    ) : Response<TvShowsResponse> {
        return movieApi.getOnTheAirTvList(page = page)
    }
}
