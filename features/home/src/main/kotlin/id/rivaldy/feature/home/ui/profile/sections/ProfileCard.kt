package id.rivaldy.feature.home.ui.profile.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = Dimens.dp16, shape = RoundedCornerShape(Dimens.dp20))
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(Dimens.dp20)),
    ) {
        Spacer(modifier = modifier.height(Dimens.dp32))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.dp24),
        ) {
            Image(
                modifier = modifier
                    .size(Dimens.dp48)
                    .shadow(elevation = Dimens.dp1, shape = CircleShape)
                    .clip(shape = CircleShape),
                painter = painterResource(id = R.drawable.rival_profile),
                contentDescription = stringResource(id = R.string.my_profile),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = modifier.width(Dimens.dp16))
            Column(modifier = modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = stringResource(id = R.string.rivaldy),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = Dimens.sp20,
                    ),
                )
                Spacer(modifier = modifier.height(Dimens.dp3))
                Text(
                    text = stringResource(id = R.string.membership),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray.copy(alpha = 0.5f),
                        fontSize = Dimens.sp14,
                    ),
                )
            }
        }
        Spacer(modifier = modifier.height(Dimens.dp32))
        Spacer(modifier = modifier.height(Dimens.dp8))
        Box(
            modifier = modifier
                .background(
                    color = Color.Gray.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(topStart = Dimens.dp20),
                )
                .padding(Dimens.dp16),
        ) {
            Text(
                text = stringResource(id = R.string.fully_profile),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = Dimens.sp14,
                ),
            )
        }
    }
}