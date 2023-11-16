package id.rivaldy.feature.auth.ui.login.sections

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import id.rivaldy.core.util.Dimens
import id.rivaldy.core.util.UtilStrings

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun LoginBottom(
    modifier: Modifier = Modifier,
    onButtonActionClicked: () -> Unit,
    navigateToForm: () -> Unit,
    isFromLogin: Boolean = false,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.dp20)
    ) {
        Button(
            modifier = modifier
                .height(Dimens.dp48)
                .fillMaxWidth()
                .shadow(elevation = Dimens.dp8, shape = RoundedCornerShape(Dimens.dp8)),
            shape = RoundedCornerShape(Dimens.dp8),
            onClick = onButtonActionClicked,
            enabled = true,
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(id = if (isFromLogin) R.string.login else R.string.register),
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
                    navigateToForm()
                },
            text = if (isFromLogin) UtilStrings.noAccountSpanned() else UtilStrings.haveAccountSpanned(),
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