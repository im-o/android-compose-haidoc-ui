package id.rivaldy.composehaidoc.ui.navdrawer.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import id.rivaldy.core.data.model.local.screen.drawer.NavDrawerModel
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun NavDrawerContent(
    modifier: Modifier = Modifier,
    navigationItemContentList: List<NavDrawerModel>,
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    Row(
        modifier = modifier
            .background(Color.Transparent)
            .fillMaxSize()
    ) {
        NavDrawerTransparent(modifier = modifier)
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(modifier = modifier.padding(start = Dimens.dp40, end = Dimens.dp100)) {
                Spacer(modifier = modifier.height(Dimens.dp120))
                NavDrawerHeader(modifier = modifier)
                Spacer(modifier = modifier.height(Dimens.dp32))
                NavDrawerMenu(
                    modifier = modifier,
                    navigationItemContentList = navigationItemContentList,
                    navController = navController,
                    currentDestination = currentDestination
                )
            }
            Spacer(modifier = modifier.height(Dimens.dp80))
            NavDrawerBottom(modifier = modifier)
        }
    }
}