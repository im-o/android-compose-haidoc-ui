package id.rivaldy.core.data.model.local.screen.drawer

import id.rivaldy.core.R

/** Created by github.com/im-o on 11/15/2023. */

open class NavDrawerRoute(val route: String) {
    object Home : NavDrawerModel(
        route = HOME_ROUTE,
        titleResId = R.string.home,
    )

    object Profile : NavDrawerModel(
        route = PROFILE_ROUTE,
        titleResId = R.string.my_profile,
    )

    object Setting : NavDrawerModel(
        route = SETTING_ROUTE,
        titleResId = R.string.setting,
    )

    companion object {
        const val HOME_ROUTE = "main/home"
        const val PROFILE_ROUTE = "main/profile"
        const val SETTING_ROUTE = "main/setting"
    }
}