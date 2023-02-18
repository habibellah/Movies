package habibellah.ayata.movies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import habibellah.ayata.domain.repositories.MovieRepository
import habibellah.ayata.domain.useCase.GetMovies

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

  @Provides
  fun provideUseCase(movieRepository: MovieRepository):GetMovies{
    return GetMovies(movieRepository)
  }
}