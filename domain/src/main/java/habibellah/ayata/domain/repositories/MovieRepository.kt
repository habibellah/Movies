package habibellah.ayata.domain.repositories

import habibellah.ayata.domain.entity.MovieDetailsResponse
import habibellah.ayata.domain.entity.MovieResponse
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun getMovieListByType(movieType : String): Flow<MovieState<MovieResponse?>>
    fun getTrendingMovieList(): Flow<MovieState<MovieResponse?>>
    fun getOnTheAirTvList(): Flow<MovieState<MovieResponse?>>
    suspend fun getMovieDetails(movieId : Int): Flow<MovieState<MovieDetailsResponse?>>
}