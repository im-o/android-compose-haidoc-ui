package id.rivaldy.feature.auth.ui.login.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import id.rivaldy.core.R
import id.rivaldy.core.data.model.remote.login.LoginRequest
import id.rivaldy.core.ui.molecules.PasswordField
import id.rivaldy.core.ui.molecules.RegularField
import id.rivaldy.core.ui.molecules.text.FormHintText
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    loginRequest: (LoginRequest) -> Unit,
) {
    val email = remember { mutableStateOf(String()) }
    val password = remember { mutableStateOf(String()) }
    loginRequest(LoginRequest(email = email.value, password = password.value))

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.dp20)
    ) {
        FormHintText(stringResource(id = R.string.email))
        Spacer(modifier = modifier.height(Dimens.dp16))
        RegularField(stringResource(id = R.string.input_email)) { email.value = it }
        Spacer(modifier = modifier.height(Dimens.dp40))
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FormHintText(stringResource(id = R.string.password))
            Text(
                text = stringResource(id = R.string.forgot_your_password),
                style = TextStyle(
                    fontSize = Dimens.sp14,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    fontWeight = FontWeight.Bold,
                )
            )
        }
        Spacer(modifier = modifier.height(Dimens.dp16))
        PasswordField(
            hint = stringResource(id = R.string.input_password),
            imeAction = ImeAction.Done
        ) { password.value = it }
    }
}