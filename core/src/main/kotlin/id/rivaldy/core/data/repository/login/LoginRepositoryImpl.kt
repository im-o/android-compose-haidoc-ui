package id.rivaldy.core.data.repository.login

import id.rivaldy.core.data.datasource.remote.ApiService
import id.rivaldy.core.data.model.remote.login.LoginRequest
import id.rivaldy.core.data.model.remote.login.LoginResponse
import id.rivaldy.core.domain.repository.login.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/** Created by github.com/im-o on 11/15/2023. */

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : LoginRepository {
    override suspend fun loginUserApiCall(request: LoginRequest): Flow<LoginResponse> {
        return flow {
            emit(apiService.loginUser(request.email ?: "", request.password ?: ""))
        }
    }
}