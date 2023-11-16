package id.rivaldy.composehaidoc.ui.navdrawer.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import id.rivaldy.core.R
import id.rivaldy.core.data.model.local.screen.drawer.NavDrawerModel
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun NavDrawerMenu(
    modifier: Modifier = Modifier,
    navigationItemContentList: List<NavDrawerModel>,
    navController: NavHostController,
    currentDestination: NavDestination?,
    onDrawerAction: () -> Unit,
) {
    Column {
        navigationItemContentList.forEach { screen ->
            NavDrawerItem(
                modifier = modifier,
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
                onDrawerAction = onDrawerAction
            )
            Spacer(modifier = modifier.height(Dimens.dp8))
        }
        Spacer(modifier = modifier.height(Dimens.dp32))
        Button(
            modifier = modifier
                .height(Dimens.dp32)
                .fillMaxWidth(),
            shape = RoundedCornerShape(Dimens.dp16),
            onClick = {},
            enabled = true,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red.copy(alpha = 0.8f)),
        ) {
            Text(
                text = stringResource(id = R.string.logout),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = Dimens.sp11,
                ),
            )
        }
    }
}

@Composable
fun NavDrawerItem(
    modifier: Modifier = Modifier,
    screen: NavDrawerModel,
    currentDestination: NavDestination?,
    navController: NavHostController,
    onDrawerAction: () -> Unit,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val contentColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.dp32)
            .clickable(onClick = {
                onDrawerAction()
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = modifier
                .padding(vertical = Dimens.dp3)
                .align(Alignment.CenterVertically),
            text = stringResource(id = screen.titleResId),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = contentColor,
                fontSize = Dimens.sp12,
            ),
        )
        Icon(
            modifier = Modifier
                .size(Dimens.dp12)
                .align(Alignment.CenterVertically),
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = stringResource(R.string.close),
            tint = contentColor,
        )
    }
}