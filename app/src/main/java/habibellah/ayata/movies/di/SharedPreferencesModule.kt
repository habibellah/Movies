package habibellah.ayata.movies.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import habibellah.ayata.data.movieAppDataSource.local.SharedPreferences
import habibellah.ayata.data.movieAppDataSource.local.SharedPreferencesImpl

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context : Context):SharedPreferences{
  return SharedPreferencesImpl(context)
    }
}