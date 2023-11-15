package id.rivaldy.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.rivaldy.core.data.datasource.remote.ApiService
import id.rivaldy.core.data.repository.login.LoginRepositoryImpl
import id.rivaldy.core.domain.repository.login.LoginRepository
import javax.inject.Singleton

/** Created by github.com/im-o on 11/15/2023. */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideLoginRepository(apiService: ApiService): LoginRepository = LoginRepositoryImpl(apiService)
}