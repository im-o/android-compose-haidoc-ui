package id.rivaldy.feature.auth.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.rivaldy.core.data.UiState
import id.rivaldy.core.data.model.remote.login.LoginRequest
import id.rivaldy.core.data.model.remote.login.LoginResponse
import id.rivaldy.core.domain.usecase.login.LoginUseCase
import id.rivaldy.core.network.error.handleAppError
import id.rivaldy.core.util.UtilFunctions.logE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Created by github.com/im-o on 11/16/2023. */

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {

    private val _uiStateLogin: MutableStateFlow<UiState<LoginResponse>> = MutableStateFlow(UiState.Initial)
    val uiStateLogin: StateFlow<UiState<LoginResponse>>
        get() = _uiStateLogin

    fun loginApiCall(request: LoginRequest) {
        _uiStateLogin.value = UiState.Loading
        viewModelScope.launch {
            try {
                loginUseCase.execute(request)
                    .catch {
                        _uiStateLogin.value = it.handleAppError()
                        logE("Hello XX 1 :$it")
                    }
                    .collect {
                        logE("Hello XX 2 :$it")
                        _uiStateLogin.value = UiState.Success(it)
                    }
            } catch (e: Exception) {
                logE("Hello XX 3 :$e")
                _uiStateLogin.value = UiState.Error(e.message.toString())
            }
        }
    }

    fun resetState() {
        _uiStateLogin.value = UiState.Initial
    }
}