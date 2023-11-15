package id.rivaldy.core.data.model.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String? = null,
    @SerializedName("error")
    val error: String? = null
)