package id.rivaldy.feature.home.ui.home.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/17/2023. */

@Composable
fun HomeSection(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Spacer(modifier = modifier.height(Dimens.dp24))
        HomeSlider()
        HomeBannerService(modifier = modifier)
        HomeBannerTrack(modifier = modifier)
        Spacer(modifier = modifier.height(Dimens.dp8))
        HomeSearchBar(modifier = modifier)
        Spacer(modifier = modifier.height(Dimens.dp40))
        HomeCategoryFilter(modifier = modifier)
        Spacer(modifier = modifier.height(Dimens.dp24))
        HomeProduct(modifier = modifier)
        Spacer(modifier = modifier.height(Dimens.dp40))
        HomeServiceType(modifier = modifier)
        Spacer(modifier = modifier.height(Dimens.dp40))
        HomeService(modifier = modifier)
    }
}