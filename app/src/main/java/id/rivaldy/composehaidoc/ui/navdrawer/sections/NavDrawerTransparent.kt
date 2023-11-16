package id.rivaldy.composehaidoc.ui.navdrawer.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun NavDrawerTransparent(
    modifier: Modifier = Modifier,
    onDrawerAction: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.7f))
            .fillMaxHeight()
            .width(Dimens.dp55)
    ) {
        Spacer(modifier = modifier.height(Dimens.dp38))
        Icon(
            modifier = Modifier
                .clickable {
                    onDrawerAction()
                }
                .align(Alignment.CenterHorizontally)
                .size(Dimens.dp24),
            painter = painterResource(id = R.drawable.circle_close),
            contentDescription = stringResource(R.string.close),
            tint = Color.White,
        )
    }
}