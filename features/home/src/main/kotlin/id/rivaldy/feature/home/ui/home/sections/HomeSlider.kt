package id.rivaldy.feature.home.ui.home.sections

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens
import id.rivaldy.core.util.UtilStrings

/** Created by github.com/im-o on 11/17/2023. */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeSlider(
    modifier: Modifier = Modifier,
) {
    val items = listOf("1", "2", "3", "4")
    val pagerState = rememberPagerState()
    HorizontalPager(
        count = items.size,
        state = pagerState,
    ) { page ->
        BannerSlider(
            modifier = modifier,
            pagerState = pagerState,
            items = items,
            page = page,
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerSlider(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    items: List<String>,
    page: Int,
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
                .shadow(elevation = Dimens.dp16, shape = RoundedCornerShape(Dimens.dp16))
                .background(Color.White, RoundedCornerShape(Dimens.dp16)),
        ) {
            Spacer(modifier = modifier.height(Dimens.dp16))
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = Dimens.dp16, end = Dimens.dp100)
            ) {
                Text(
                    text = UtilStrings.titleSliderSpanned(),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = Dimens.sp20,
                    ),
                )
                Spacer(modifier = modifier.height(Dimens.dp3))
                Text(
                    text = "${items[page]}. ${stringResource(id = R.string.update_information)}",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray.copy(alpha = 0.5f),
                        fontSize = Dimens.sp14,
                    ),
                )
            }
            Spacer(modifier = modifier.height(Dimens.dp12))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = Dimens.dp20),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    modifier = modifier
                        .height(Dimens.dp32)
                        .padding(start = Dimens.dp16)
                        .wrapContentWidth(),
                    shape = RoundedCornerShape(Dimens.dp8),
                    onClick = {},
                    enabled = true,
                ) {
                    Text(
                        text = stringResource(id = R.string.more),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = Dimens.sp12,
                            color = Color.White
                        ),
                    )
                }
                HorizontalTabs(
                    items = items,
                    pagerState = pagerState
                )
            }
            Spacer(modifier = modifier.height(Dimens.dp16))
        }
        Box(
            modifier = modifier
                .padding(end = Dimens.dp16)
                .wrapContentSize()
                .align(Alignment.TopEnd),
        ) {
            Image(
                modifier = modifier.size(Dimens.dp120),
                painter = painterResource(id = R.drawable.calendar_widget),
                contentDescription = stringResource(id = R.string.my_profile),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun HorizontalTabs(
    items: List<String?>?,
    pagerState: PagerState,
) {
    val dotRadius = 4.dp
    val dotSpacing = 8.dp

    Box(
        modifier = Modifier
            .height(dotRadius * 2)
            .wrapContentWidth()
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(dotSpacing),
        ) {
            items?.forEachIndexed { index, _ ->
                val animatedWidth by animateIntAsState(
                    targetValue = if (pagerState.currentPage == index) dotRadius.value.toInt() * 12 else dotRadius.value.toInt() * 2, label = ""
                )
                Box(
                    modifier = Modifier
                        .height(dotRadius * 2)
                        .width(animatedWidth.dp)
                        .clip(
                            if (pagerState.currentPage == index) {
                                RoundedCornerShape(dotRadius)
                            } else {
                                CircleShape
                            }
                        )
                        .background(
                            if (pagerState.currentPage == index) Color.LightGray else Color.LightGray.copy(alpha = 0.5f)
                        ),
                )
            }
        }
    }
}