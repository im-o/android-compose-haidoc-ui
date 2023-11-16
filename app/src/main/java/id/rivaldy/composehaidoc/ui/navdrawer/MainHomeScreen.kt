package id.rivaldy.composehaidoc.ui.navdrawer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import id.rivaldy.core.data.model.local.screen.drawer.NavDrawerRoute

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun MainHomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navigationItemContentList = listOf(
        NavDrawerRoute.Home,
        NavDrawerRoute.Profile,
        NavDrawerRoute.Setting,
    )

    NavDrawer(
        modifier = modifier,
        navigationItemContentList = navigationItemContentList,
        navController = navController,
        currentDestination = currentDestination,
    )
}