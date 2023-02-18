package habibellah.ayata.domain.useCase

import habibellah.ayata.domain.repositories.MovieRepository

class GetMovies (private val movieRepository: MovieRepository) {
  fun getMovieListByType(movieType : String) = movieRepository.getMovieListByType(movieType)
  fun getTrendingMovieList() = movieRepository.getTrendingMovieList()
  fun getOnTheAirTvList() = movieRepository.getOnTheAirTvList()
  suspend fun getMovieDetails(movieId : Int) = movieRepository.getMovieDetails(movieId)
}