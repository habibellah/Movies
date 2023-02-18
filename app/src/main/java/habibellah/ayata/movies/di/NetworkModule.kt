package habibellah.ayata.movies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import habibellah.ayata.data.movieDataSource.remote.movieApi.MovieApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  private const val BASE_URL = "https://api.themoviedb.org/3/"
  @Singleton
  @Provides
  fun provideMovieService() : MovieApi {
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(MovieApi::class.java)
  }

}