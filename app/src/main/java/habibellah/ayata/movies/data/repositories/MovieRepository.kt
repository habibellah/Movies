package habibellah.ayata.movies.data.repositories

import habibellah.ayata.movies.data.movieDataSource.movieApi.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovieListByType(movieType : String): Flow<MovieState<MovieResponse?>>
    fun getTrendingMovieList(): Flow<MovieState<MovieResponse?>>
    fun getOnTheAirTvList(): Flow<MovieState<MovieResponse?>>
}