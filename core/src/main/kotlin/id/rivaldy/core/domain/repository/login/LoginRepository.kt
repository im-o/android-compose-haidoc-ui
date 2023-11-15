package id.rivaldy.core.domain.repository.login

import id.rivaldy.core.data.model.remote.login.LoginRequest
import id.rivaldy.core.data.model.remote.login.LoginResponse
import kotlinx.coroutines.flow.Flow

/** Created by github.com/im-o on 11/15/2023. */

interface LoginRepository {
    suspend fun loginUserApiCall(request: LoginRequest): Flow<LoginResponse>
}