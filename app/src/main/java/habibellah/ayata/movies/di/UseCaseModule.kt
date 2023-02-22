package habibellah.ayata.movies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import habibellah.ayata.data.movieAppDataSource.local.SharedPreferences
import habibellah.ayata.domain.repositories.AuthenticationRepository
import habibellah.ayata.domain.repositories.MovieRepository
import habibellah.ayata.domain.repositories.UserInfoRepository
import habibellah.ayata.domain.useCase.GetMoviesUseCase
import habibellah.ayata.domain.useCase.GetUserInfoUseCase
import habibellah.ayata.domain.useCase.ValidateUserInfoUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

  @Provides
  fun provideGetMoviesUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
    return GetMoviesUseCase(movieRepository)
  }

  @Provides
  fun provideGetUserInfoUseCase(userInfoRepository : UserInfoRepository):GetUserInfoUseCase{
    return GetUserInfoUseCase(userInfoRepository)
  }

  @Provides
  fun provideValidateUserInfoUseCase(authenticationRepository : AuthenticationRepository,userInfoRepository : UserInfoRepository):ValidateUserInfoUseCase{
    return ValidateUserInfoUseCase(authenticationRepository,userInfoRepository)
  }
}