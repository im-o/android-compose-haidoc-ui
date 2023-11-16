package id.rivaldy.composehaidoc.ui.navdrawer

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import id.rivaldy.composehaidoc.ui.navdrawer.sections.NavDrawerContent
import id.rivaldy.composehaidoc.ui.navigation.MainNavGraph
import id.rivaldy.core.data.model.local.screen.drawer.NavDrawerModel

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun NavDrawer(
    modifier: Modifier = Modifier,
    navigationItemContentList: List<NavDrawerModel>,
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.Transparent,
                drawerShape = RectangleShape
            ) {
                NavDrawerContent(
                    modifier = modifier,
                    navigationItemContentList = navigationItemContentList,
                    navController = navController,
                    currentDestination = currentDestination
                )
            }
        }
    ) {
        MainNavGraph(navController = navController)
    }
}