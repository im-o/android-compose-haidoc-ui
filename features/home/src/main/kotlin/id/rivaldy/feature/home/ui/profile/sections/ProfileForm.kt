package id.rivaldy.feature.home.ui.profile.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import id.rivaldy.core.R
import id.rivaldy.core.ui.molecules.RegularField
import id.rivaldy.core.ui.molecules.text.FormHintText
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun ProfileForm(
    modifier: Modifier = Modifier,
) {
    val firstName = remember { mutableStateOf(String()) }
    val lastName = remember { mutableStateOf(String()) }
    val idNumber = remember { mutableStateOf(String()) }
    val email = remember { mutableStateOf(String()) }
    val phoneNumber = remember { mutableStateOf(String()) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.dp20)
    ) {
        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.first_name))
        Spacer(modifier = modifier.height(Dimens.dp16))
        RegularField(hint = stringResource(id = R.string.first_name), keyboardType = KeyboardType.Text) { firstName.value = it }

        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.last_name))
        Spacer(modifier = modifier.height(Dimens.dp16))
        RegularField(hint = stringResource(id = R.string.last_name), keyboardType = KeyboardType.Text) { lastName.value = it }

        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.email))
        Spacer(modifier = modifier.height(Dimens.dp16))
        RegularField(hint = stringResource(id = R.string.input_email), keyboardType = KeyboardType.Email) { email.value = it }

        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.phone_number))
        Spacer(modifier = modifier.height(Dimens.dp16))
        RegularField(hint = stringResource(id = R.string.input_phone_number), keyboardType = KeyboardType.Phone) { phoneNumber.value = it }

        Spacer(modifier = modifier.height(Dimens.dp40))
        FormHintText(stringResource(id = R.string.id_number))
        Spacer(modifier = modifier.height(Dimens.dp16))
        RegularField(
            hint = stringResource(id = R.string.input_id_number),
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ) { idNumber.value = it }

        Spacer(modifier = modifier.height(Dimens.dp40))
        Button(
            modifier = modifier
                .height(Dimens.dp48)
                .fillMaxWidth()
                .shadow(elevation = Dimens.dp8, shape = RoundedCornerShape(Dimens.dp8)),
            shape = RoundedCornerShape(Dimens.dp8),
            onClick = {},
            enabled = true,
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(id = R.string.save_profile),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = Dimens.sp16,
                    ),
                )
                Icon(
                    modifier = Modifier
                        .size(Dimens.dp16)
                        .align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.baseline_save_24),
                    contentDescription = null,
                )
            }
        }
    }
}