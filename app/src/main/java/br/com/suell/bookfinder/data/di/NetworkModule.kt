package br.com.suell.bookfinder.data.di

import br.com.suell.bookfinder.data.remote.OpenLibraryApi
import br.com.suell.bookfinder.data.remote.RetrofitInstance
import br.com.suell.bookfinder.data.repository.BookRepositoryImpl
import br.com.suell.bookfinder.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApi(): OpenLibraryApi {
        return RetrofitInstance.api
    }

    @Provides
    @Singleton
    fun provideBookRepository(
        api: OpenLibraryApi,
        dao: br.com.suell.bookfinder.data.local.BookDao
    ): BookRepository {
        return BookRepositoryImpl(api, dao)
    }
}