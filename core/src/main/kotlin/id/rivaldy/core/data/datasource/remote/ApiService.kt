package id.rivaldy.core.data.datasource.remote

import id.rivaldy.core.data.model.remote.login.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/** Created by github.com/im-o on 11/15/2023. */

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String,
    ): LoginResponse
}