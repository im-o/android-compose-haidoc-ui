package id.rivaldy.feature.auth.ui.login.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import id.rivaldy.core.R
import id.rivaldy.core.ui.molecules.PasswordField
import id.rivaldy.core.ui.molecules.RegularField
import id.rivaldy.core.ui.molecules.text.FormHintText
import id.rivaldy.core.util.Dimens
import id.rivaldy.core.util.UtilStrings

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToRegister: () -> Unit,
) {
    val email = remember { mutableStateOf(String()) }
    val password = remember { mutableStateOf(String()) }

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
        PasswordField { password.value = it }
        Spacer(modifier = modifier.height(Dimens.dp40))
        Button(
            modifier = modifier
                .height(Dimens.dp48)
                .fillMaxWidth()
                .shadow(elevation = Dimens.dp8, shape = RoundedCornerShape(Dimens.dp8)),
            shape = RoundedCornerShape(Dimens.dp8),
            onClick = navigateToHome,
            enabled = true,
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(id = R.string.login),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = Dimens.sp16,
                    ),
                )
                Icon(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = modifier.height(Dimens.dp32))
        Text(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    navigateToRegister()
                },
            text = UtilStrings.noAccountSpanned(),
            style = TextStyle(fontSize = Dimens.sp14),
        )
        Spacer(modifier = modifier.height(Dimens.dp40))
        Row(
            modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = modifier.size(Dimens.dp16),
                painter = painterResource(id = R.drawable.baseline_copyright_24),
                contentDescription = null,
                tint = Color.Gray.copy(alpha = 0.4f)
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = stringResource(R.string.right_reserved),
                style = TextStyle(
                    fontSize = Dimens.sp14,
                    color = Color.Gray.copy(alpha = 0.4f)
                ),
            )
        }
    }
}