package id.rivaldy.core.network.error

import id.rivaldy.core.data.UiState
import retrofit2.HttpException
import java.io.IOException

/** Created by github.com/im-o on 11/16/2023. */

sealed class AppError {
    data class NetworkError(val message: String) : AppError()
    data class MessageFailed(val message: String) : AppError()
    data class UnknownError(val message: String) : AppError()
}

private fun AppError.toUiStateError(): UiState.Error {
    return when (this) {
        is AppError.NetworkError -> UiState.Error(message)
        is AppError.MessageFailed -> UiState.Error(message)
        is AppError.UnknownError -> UiState.Error(message)
    }
}

fun Throwable.handleAppError(): UiState.Error {
    val appError = when (this) {
        is IOException -> AppError.NetworkError("Oops, No internet connection.")
        is HttpException -> {
            if (this.code() == 400) {
                AppError.MessageFailed("Failed to login. try again!")
            } else {
                AppError.MessageFailed("Something went wrong, try again!")
            }
        }

        else -> AppError.UnknownError(this.message.toString())
    }
    return appError.toUiStateError()
}

