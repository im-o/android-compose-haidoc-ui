package id.rivaldy.composehaidoc.ui.navdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import id.rivaldy.composehaidoc.ui.navigation.MainNavGraph
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/17/2023. */

@Composable
fun NavDrawerContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onDrawerAction: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Row(
            modifier = modifier
                .height(Dimens.dp100)
                .fillMaxSize()
                .padding(start = Dimens.dp20, end = Dimens.dp32)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .size(Dimens.dp28)
                    .clickable { onDrawerAction() },
                painter = painterResource(id = R.drawable.ic_dash),
                contentDescription = stringResource(R.string.close),
                tint = MaterialTheme.colorScheme.primary,
            )
            Row(
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = modifier.size(Dimens.dp20),
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = stringResource(R.string.close),
                    tint = MaterialTheme.colorScheme.primary,
                )
                Spacer(modifier = modifier.width(Dimens.dp32))
                Icon(
                    modifier = modifier.size(Dimens.dp20),
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = stringResource(R.string.close),
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
        MainNavGraph(navController = navController)
    }
}