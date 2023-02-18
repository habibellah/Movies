package habibellah.ayata.movies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import habibellah.ayata.data.movieDataSource.remote.movieApi.MovieApi
import habibellah.ayata.data.repositories.MovieRepositoryImpl
import habibellah.ayata.domain.repositories.MovieRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

  @Provides
  fun provideMovieRepositoryForHomeViewModel(movieApi: MovieApi): MovieRepository {
    return MovieRepositoryImpl(movieApi)
  }

}