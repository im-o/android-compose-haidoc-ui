package id.rivaldy.composehaidoc.ui.navdrawer.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun NavDrawerBottom(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = modifier.padding(vertical = Dimens.dp3),
            text = "Ikuti kami di",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = Dimens.sp18,
            ),
        )
        Spacer(modifier = modifier.width(Dimens.dp12))
        Icon(
            modifier = Modifier.size(Dimens.dp10),
            painter = painterResource(id = R.drawable.ic_fb),
            contentDescription = stringResource(R.string.close),
            tint = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = modifier.width(Dimens.dp8))
        Icon(
            modifier = Modifier.size(Dimens.dp12),
            painter = painterResource(id = R.drawable.ic_instagram),
            contentDescription = stringResource(R.string.close),
            tint = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = modifier.width(Dimens.dp8))
        Icon(
            modifier = Modifier.size(Dimens.dp12),
            painter = painterResource(id = R.drawable.ic_twitter),
            contentDescription = stringResource(R.string.close),
            tint = MaterialTheme.colorScheme.primary,
        )
    }
}