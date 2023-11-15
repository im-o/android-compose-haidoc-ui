package id.rivaldy.feature.auth.ui.login.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens
import id.rivaldy.core.util.UtilStrings

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun LoginHeader(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = Dimens.dp20)
    ) {
        Text(
            text = UtilStrings.welcomeSpanned(),
            style = TextStyle(fontSize = Dimens.sp28),
        )
        Spacer(modifier = modifier.height(Dimens.dp3))
        Text(
            text = stringResource(id = R.string.login_to_continue),
            style = TextStyle(
                fontSize = Dimens.sp12,
                color = MaterialTheme.colorScheme.primaryContainer,
            ),
        )
        Image(
            modifier = modifier
                .padding(start = Dimens.dp40)
                .align(Alignment.End),
            painter = painterResource(id = R.drawable.login_header),
            contentDescription = "welcome",
        )
    }
}