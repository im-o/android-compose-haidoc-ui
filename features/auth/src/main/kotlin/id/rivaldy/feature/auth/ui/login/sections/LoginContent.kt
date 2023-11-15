package id.rivaldy.feature.auth.ui.login.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import id.rivaldy.core.R
import id.rivaldy.core.ui.molecules.PasswordField
import id.rivaldy.core.ui.molecules.RegularField
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun LoginContent(
    navigateToHome: () -> Unit,
) {
    val email = remember { mutableStateOf(String()) }
    val password = remember { mutableStateOf(String()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.dp20)
    ) {
        Text(
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.displayLarge,
        )
        Spacer(modifier = Modifier.height(Dimens.dp3))
        Text(
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.labelSmall,
        )
        Spacer(modifier = Modifier.height(Dimens.dp16))
        RegularField(stringResource(id = R.string.input_email)) { email.value = it }
        Spacer(modifier = Modifier.height(Dimens.dp8))
        PasswordField { password.value = it }
        Spacer(modifier = Modifier.height(Dimens.dp16))
        Button(
            modifier = Modifier
                .height(Dimens.dp48)
                .fillMaxWidth(),
            shape = RoundedCornerShape(Dimens.dp8),
            onClick = navigateToHome,
            enabled = true,
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}