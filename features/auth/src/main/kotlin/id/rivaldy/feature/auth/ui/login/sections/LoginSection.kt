package id.rivaldy.feature.auth.ui.login.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import id.rivaldy.core.data.model.remote.login.LoginRequest
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun LoginSection(
    modifier: Modifier = Modifier,
    onButtonActionClicked: (LoginRequest) -> Unit,
    navigateToForm: () -> Unit,
) {
    val loginRequest = remember { mutableStateOf(LoginRequest()) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = modifier.height(Dimens.dp80))
        LoginHeader(modifier = modifier)
        LoginForm(modifier = modifier) {
            loginRequest.value = it
        }
        Spacer(modifier = modifier.height(Dimens.dp40))
        LoginBottom(
            modifier = modifier,
            onButtonActionClicked = { onButtonActionClicked(loginRequest.value) },
            navigateToForm = navigateToForm,
            isFromLogin = true,
        )
        Spacer(modifier = modifier.height(Dimens.dp60))
    }
}