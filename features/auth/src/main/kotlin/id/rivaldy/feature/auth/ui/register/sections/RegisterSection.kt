package id.rivaldy.feature.auth.ui.register.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.rivaldy.core.util.Dimens
import id.rivaldy.feature.auth.ui.login.sections.LoginBottom
import id.rivaldy.feature.auth.ui.login.sections.LoginHeader

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun RegisterSection(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToForm: () -> Unit,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = modifier.height(Dimens.dp80))
        LoginHeader(modifier = modifier)
        RegisterForm(modifier = modifier)
        Spacer(modifier = modifier.height(Dimens.dp40))
        LoginBottom(
            modifier = modifier,
            onButtonActionClicked = navigateToHome,
            navigateToForm = navigateToForm,
            isFromLogin = false,
        )
        Spacer(modifier = modifier.height(Dimens.dp60))
    }
}