package habibellah.ayata.movies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import habibellah.ayata.data.movieAppDataSource.local.SharedPreferences
import habibellah.ayata.data.movieAppDataSource.remote.movieApi.MovieApi
import habibellah.ayata.data.repositories.AuthenticationRepositoryImpl
import habibellah.ayata.data.repositories.MovieRepositoryImpl
import habibellah.ayata.data.repositories.UserInfoRepositoryImpl
import habibellah.ayata.domain.repositories.AuthenticationRepository
import habibellah.ayata.domain.repositories.MovieRepository
import habibellah.ayata.domain.repositories.UserInfoRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

  @Provides
  fun provideMovieRepository(movieApi: MovieApi): MovieRepository {
    return MovieRepositoryImpl(movieApi)
  }

  @Provides
  fun provideUserInfoRepository(preferencesDataStore : SharedPreferences):UserInfoRepository{
    return UserInfoRepositoryImpl(preferencesDataStore)
  }

  @Provides
  fun provideAuthenticationRepository(movieApi : MovieApi):AuthenticationRepository{
    return AuthenticationRepositoryImpl(movieApi)
  }
}