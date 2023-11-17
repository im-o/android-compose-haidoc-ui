package id.rivaldy.feature.home.ui.home.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/17/2023. */

@Composable
fun HomeBannerService(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.dp16, vertical = Dimens.dp32)
                .shadow(elevation = Dimens.dp3, shape = RoundedCornerShape(Dimens.dp16))
                .background(Color.White, RoundedCornerShape(Dimens.dp16)),
        ) {
            Spacer(modifier = modifier.height(Dimens.dp16))
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = Dimens.dp16, end = Dimens.dp100)
            ) {
                Text(
                    text = stringResource(id = R.string.priority_service),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = Dimens.sp20,
                    ),
                )
                Spacer(modifier = modifier.height(Dimens.dp3))
                Text(
                    text = stringResource(id = R.string.covid_test),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray.copy(alpha = 0.5f),
                        fontSize = Dimens.sp14,
                    ),
                )
                Spacer(modifier = modifier.height(Dimens.dp16))
                Row(
                    modifier = modifier
                        .wrapContentWidth()
                        .clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(
                        text = stringResource(id = R.string.join_test),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = Dimens.sp18,
                            color = MaterialTheme.colorScheme.primary,
                        ),
                    )
                    Spacer(modifier = modifier.width(Dimens.dp8))
                    Icon(
                        modifier = Modifier.size(Dimens.dp16),
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
                Spacer(modifier = modifier.height(Dimens.dp16))
            }
        }
        Box(
            modifier = modifier
                .padding(end = Dimens.dp32)
                .wrapContentSize()
                .align(Alignment.TopEnd),
        ) {
            Image(
                modifier = modifier.size(Dimens.dp100),
                painter = painterResource(id = R.drawable.covid_widget),
                contentDescription = stringResource(id = R.string.image),
                contentScale = ContentScale.Crop,
            )
        }
    }
}