package id.rivaldy.core.data.model.local.screen.drawer

import androidx.annotation.StringRes

/** Created by github.com/im-o on 11/15/2023. */

sealed class NavDrawerModel(
    val route: String,
    @StringRes val titleResId: Int,
)