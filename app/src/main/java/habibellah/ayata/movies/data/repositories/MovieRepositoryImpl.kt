package habibellah.ayata.movies.data.repositories

import habibellah.ayata.movies.data.movieDataSource.movieApi.MovieApi
import habibellah.ayata.movies.data.movieDataSource.movieApi.MovieResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MovieRepositoryImpl (private val movieApi: MovieApi): MovieRepository {
    override fun getMovieListByType(movieType: String): Flow<MovieState<MovieResponse?>> {
        return wrapWithFlow {
            movieApi.getMoviesListByType(movieType = movieType)
        }
        }
    }

    fun <T> wrapWithFlow(function: suspend ()-> Response<T>) : Flow<MovieState<T?>>{
        return flow {
            emit(MovieState.Loading)
            try {
                val result = function()
                if(result.isSuccessful){
                    emit(MovieState.Success(result.body()))
                }else{
                    emit(MovieState.Error(result.message()))
                }
            }catch (e : Exception){
                emit(MovieState.Error(e.message.toString()))
            }
        }
    }
