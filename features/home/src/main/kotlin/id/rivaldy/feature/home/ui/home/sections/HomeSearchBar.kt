package id.rivaldy.feature.home.ui.home.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import id.rivaldy.core.R
import id.rivaldy.core.ui.molecules.SearchBar
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/17/2023. */

@Composable
fun HomeSearchBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(horizontal = Dimens.dp16)
            .fillMaxWidth(),
    ) {
        Box(
            modifier = modifier
                .size(Dimens.dp40)
                .shadow(elevation = Dimens.dp3, shape = CircleShape)
                .background(color = Color.White, shape = CircleShape)
                .clickable { },
        ) {
            Icon(
                modifier = modifier
                    .fillMaxSize()
                    .padding(Dimens.dp12),
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = stringResource(R.string.close),
                tint = MaterialTheme.colorScheme.primary,
            )
        }
        Spacer(modifier = modifier.width(Dimens.dp24))
        SearchBar(
            hint = stringResource(R.string.search),
            cornerShape = RoundedCornerShape(Dimens.dp20),
        )
    }
}