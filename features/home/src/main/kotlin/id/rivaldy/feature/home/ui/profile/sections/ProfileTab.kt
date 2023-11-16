package id.rivaldy.feature.home.ui.profile.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun ProfileTab(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(Dimens.dp40)
                .padding(horizontal = Dimens.dp48)
                .shadow(elevation = Dimens.dp16, shape = RoundedCornerShape(Dimens.dp20))
                .background(Color.White, RoundedCornerShape(Dimens.dp20)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(Dimens.dp3)
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(Dimens.dp20),
                    ),
            ) {
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    text = stringResource(id = R.string.my_profile),
                    style = TextStyle(
                        textAlign = TextAlign.Center
                    )
                )
            }
            Text(
                modifier = modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(Dimens.dp3)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(Dimens.dp20),
                    )
                    .align(Alignment.CenterVertically),
                text = stringResource(id = R.string.setting),
                style = TextStyle(
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}