package id.rivaldy.core.domain.usecase.login

import id.rivaldy.core.data.model.login.LoginRequest
import id.rivaldy.core.data.model.login.LoginResponse
import id.rivaldy.core.domain.repository.login.LoginRepository
import id.rivaldy.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/** Created by github.com/im-o on 11/15/2023. */

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) : BaseUseCase<LoginRequest, Flow<LoginResponse>>() {
    override suspend fun execute(params: LoginRequest): Flow<LoginResponse> {
        return loginRepository.loginUserApiCall(params)
    }
}