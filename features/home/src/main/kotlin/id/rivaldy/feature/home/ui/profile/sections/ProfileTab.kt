package id.rivaldy.feature.home.ui.profile.sections

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun ProfileTab(
    modifier: Modifier = Modifier
) {
    var selectedService by remember { mutableStateOf(0) }
    val serviceTypes = listOf(stringResource(id = R.string.my_profile), stringResource(id = R.string.setting))
    Box(
        modifier = modifier
            .wrapContentSize()
            .shadow(elevation = Dimens.dp16, shape = RoundedCornerShape(Dimens.dp20))
            .background(
                color = Color.White,
                shape = RoundedCornerShape(Dimens.dp20),
            )
    ) {
        LazyRow(
            modifier = modifier.wrapContentWidth(),
            contentPadding = PaddingValues(Dimens.dp3),
            horizontalArrangement = Arrangement.spacedBy(Dimens.dp3),
        ) {
            items(count = serviceTypes.size) { index ->
                val isSelected = selectedService == index
                val backgroundColor by animateColorAsState(
                    targetValue = if (isSelected) MaterialTheme.colorScheme.secondary else Color.White,
                    animationSpec = tween(durationMillis = 500),
                    label = stringResource(id = R.string.search),
                )
                Row(
                    modifier = modifier
                        .wrapContentWidth()
                        .height(Dimens.dp35)
                        .clip(shape = RoundedCornerShape(Dimens.dp20))
                        .background(
                            color = backgroundColor,
                            shape = RoundedCornerShape(Dimens.dp20),
                        )
                        .clickable {
                            selectedService = index
                        },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = modifier.width(Dimens.dp24))
                    Text(
                        modifier = modifier.wrapContentWidth(), text = serviceTypes[index], style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            textAlign = TextAlign.Center,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        )
                    )
                    Spacer(modifier = modifier.width(Dimens.dp24))
                }
            }
        }
    }
}