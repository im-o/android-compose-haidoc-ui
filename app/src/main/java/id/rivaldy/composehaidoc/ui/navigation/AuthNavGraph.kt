package id.rivaldy.composehaidoc.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.rivaldy.core.data.model.local.screen.auth.AuthScreenRoute
import id.rivaldy.core.util.Graph
import id.rivaldy.feature.auth.ui.login.LoginScreen

/** Created by github.com/im-o on 11/15/2023. */

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreenRoute.LoginUser.route
    ) {
        composable(route = AuthScreenRoute.LoginUser.route) {
            LoginScreen(
                navigateToHome = {
                    navController.navigate(Graph.MAIN) {
//                        popUpTo(navController.graph.findStartDestination().id) {
//                            inclusive = true
//                        }
                    }
                },
                navigateToRegister = {
                    navController.navigate(route = AuthScreenRoute.RegisterUser.route)
                },
            )
        }
    }
}