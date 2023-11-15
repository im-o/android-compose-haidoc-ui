package id.rivaldy.composehaidoc.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.rivaldy.core.data.model.local.screen.drawer.NavDrawerRoute
import id.rivaldy.core.util.Graph
import id.rivaldy.feature.home.ui.HomeScreen

/** Created by github.com/im-o on 11/15/2023. */

fun NavGraphBuilder.mainNavGraph() {
    navigation(
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