package id.rivaldy.composehaidoc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import id.rivaldy.core.util.Graph

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH,
    ) {
        authNavGraph(navController = navController)
        mainNavGraph()
    }
}