package habibellah.ayata.movies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import habibellah.ayata.movies.BuildConfig
import habibellah.ayata.movies.data.movieDataSource.movieApi.MovieApi
import habibellah.ayata.movies.data.repositories.MovieRepository
import habibellah.ayata.movies.data.repositories.MovieRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
@Singleton
@Provides
fun provideMovieService() : MovieApi{
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieApi::class.java)
}

    @Provides
    @Singleton
    fun provideMovieRepositoryForHomeViewModel(movieApi: MovieApi):MovieRepository{
        return MovieRepositoryImpl(movieApi)
    }

}