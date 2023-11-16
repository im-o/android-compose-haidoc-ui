package id.rivaldy.feature.auth.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import id.rivaldy.core.R
import id.rivaldy.core.data.UiState
import id.rivaldy.core.data.model.remote.login.LoginResponse
import id.rivaldy.core.util.UtilExtensions.myToast
import id.rivaldy.feature.auth.ui.login.sections.LoginSection

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
    navigateToRegister: () -> Unit,
) {
    val uiStateLogin by viewModel.uiStateLogin.collectAsState()

    Scaffold(
        containerColor = Color.Transparent,
    ) { innerPadding ->
        Surface(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            color = Color.Transparent
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LoginSection(
                    onButtonActionClicked = {
                        viewModel.loginApiCall(it)
                    },
                    navigateToForm = navigateToRegister,
                )
            }
            HandleUiState(uiStateLogin = uiStateLogin, navigateToHome = navigateToHome, viewModel = viewModel)
        }
    }
}

@Composable
fun HandleUiState(
    uiStateLogin: UiState<LoginResponse>,
    navigateToHome: () -> Unit,
    viewModel: LoginViewModel,
) {
    val context = LocalContext.current
    when (uiStateLogin) {
        is UiState.Initial -> {
            /** Handle some function when prepared **/
        }

        is UiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
            }
        }

        is UiState.Success -> {
            val message = stringResource(id = R.string.login_success)
            context.myToast(message)
            navigateToHome()
            viewModel.resetState()
        }

        is UiState.Error -> {
            context.myToast(uiStateLogin.errorMessage)
            viewModel.resetState()
        }
    }
}