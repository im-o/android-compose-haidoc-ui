package id.rivaldy.feature.auth.ui.register.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import id.rivaldy.core.R
import id.rivaldy.core.ui.molecules.PasswordField
import id.rivaldy.core.ui.molecules.RegularField
import id.rivaldy.core.ui.molecules.text.FormHintText
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun RegisterForm(
    modifier: Modifier = Modifier,
) {
    val firstName = remember { mutableStateOf(String()) }
    val lastName = remember { mutableStateOf(String()) }
    val idNumber = remember { mutableStateOf(String()) }
    val email = remember { mutableStateOf(String()) }
    val phoneNumber = remember { mutableStateOf(String()) }
    val password = remember { mutableStateOf(String()) }
    val confirmPassword = remember { mutableStateOf(String()) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.dp20)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                FormHintText(stringResource(id = R.string.first_name))
                Spacer(modifier = modifier.height(Dimens.dp16))
                RegularField(hint = stringResource(id = R.string.first_name)) { firstName.value = it }
            }
            Spacer(modifier = modifier.width(Dimens.dp32))
            Column(
                modifier = modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                FormHintText(stringResource(id = R.string.last_name))
                Spacer(modifier = modifier.height(Dimens.dp16))
                RegularField(hint = stringResource(id = R.string.last_name)) { lastName.value = it }
            }
        }
        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.id_number))
        Spacer(modifier = modifier.height(Dimens.dp16))
        RegularField(hint = stringResource(id = R.string.input_id_number), keyboardType = KeyboardType.Number) { idNumber.value = it }
        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.email))
        Spacer(modifier = modifier.height(Dimens.dp16))
        RegularField(hint = stringResource(id = R.string.input_email), keyboardType = KeyboardType.Email) { email.value = it }
        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.phone_number))
        Spacer(modifier = modifier.height(Dimens.dp16))
        RegularField(hint = stringResource(id = R.string.input_phone_number), keyboardType = KeyboardType.Phone) { phoneNumber.value = it }
        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.password))
        Spacer(modifier = modifier.height(Dimens.dp16))
        PasswordField(hint = stringResource(id = R.string.input_password)) { password.value = it }
        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.confirm_password))
        Spacer(modifier = modifier.height(Dimens.dp16))
        PasswordField(hint = stringResource(id = R.string.confirm_your_password), imeAction = ImeAction.Done) { confirmPassword.value = it }
    }
}