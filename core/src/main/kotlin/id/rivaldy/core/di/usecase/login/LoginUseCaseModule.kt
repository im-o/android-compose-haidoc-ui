package id.rivaldy.core.di.usecase.login

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import id.rivaldy.core.domain.repository.login.LoginRepository
import id.rivaldy.core.domain.usecase.login.LoginUseCase

/** Created by github.com/im-o on 11/15/2023. */

@Module
@InstallIn(ViewModelComponent::class)
object LoginUseCaseModule {

    @Provides
    fun provideLoginUseCase(repository: LoginRepository) = LoginUseCase(repository)
}