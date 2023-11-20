package id.rivaldy.feature.home.ui.profile.sections

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/19/2023. */

@Composable
fun ProfilePersonalTab(
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.dp20),
            text = stringResource(id = R.string.select_data),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = Dimens.sp18,
            ),
        )
        Spacer(modifier = modifier.height(Dimens.dp24))
        PersonalTabItem(modifier = modifier)
    }
}

@Composable
fun PersonalTabItem(
    modifier: Modifier = Modifier,
) {
    var selectedPersonalTab by remember { mutableStateOf(0) }
    val personalTabs = listOf("Data Diri", "Alamat")
    val icons = listOf(R.drawable.pin_personal, R.drawable.ic_marker)
    Box(
        modifier = modifier.wrapContentSize()
    ) {
        LazyRow(
            modifier = modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.spacedBy(Dimens.dp20),
            contentPadding = PaddingValues(horizontal = Dimens.dp20)
        ) {
            items(count = personalTabs.size) { index ->
                val isSelected = selectedPersonalTab == index
                val backgroundColor by animateColorAsState(
                    targetValue = if (isSelected) MaterialTheme.colorScheme.secondary else Color.Gray.copy(alpha = 0.3f),
                    animationSpec = tween(durationMillis = 500),
                    label = stringResource(id = R.string.search),
                )
                Box(
                    modifier = modifier
                        .size(Dimens.dp36)
                        .clip(shape = RoundedCornerShape(Dimens.dp20))
                        .background(
                            color = backgroundColor,
                            shape = RoundedCornerShape(Dimens.dp20)
                        )
                        .clickable { selectedPersonalTab = index },
                ) {
                    Icon(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(Dimens.dp8),
                        painter = painterResource(id = icons[index]),
                        contentDescription = stringResource(R.string.image),
                        tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
                    )
                }
                Spacer(modifier = modifier.width(Dimens.dp16))
                if (isSelected) Column(modifier = modifier) {
                    Text(
                        text = personalTabs[index],
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black.copy(alpha = 0.8f),
                            fontSize = Dimens.sp14,
                        ),
                    )
                    Spacer(modifier = modifier.height(Dimens.dp3))
                    Text(
                        text = stringResource(id = R.string.personal_data_id),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray.copy(alpha = 0.3f),
                            fontSize = Dimens.sp10,
                        ),
                    )
                }
            }
        }
    }
}