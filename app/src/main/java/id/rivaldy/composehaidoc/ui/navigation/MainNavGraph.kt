package id.rivaldy.composehaidoc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.rivaldy.core.data.model.local.screen.drawer.NavDrawerRoute
import id.rivaldy.core.util.Graph
import id.rivaldy.feature.home.ui.home.HomeScreen

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = NavDrawerRoute.Home.route,
    ) {
        composable(route = NavDrawerRoute.Home.route) {
            HomeScreen()
        }
        composable(route = NavDrawerRoute.Profile.route) {
            HomeScreen()
        }
        composable(route = NavDrawerRoute.Setting.route) {
            HomeScreen()
        }
    }
}