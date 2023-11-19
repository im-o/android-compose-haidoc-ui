package id.rivaldy.feature.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/19/2023. */

@Composable
fun Footer(
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colorScheme.primary),
    ) {
        val (askUpdate, needNotification, forwardImage) = createRefs()
        Text(
            modifier = modifier
                .constrainAs(askUpdate) {
                    top.linkTo(parent.top, margin = Dimens.dp32)
                    bottom.linkTo(parent.bottom, margin = Dimens.dp32)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(needNotification.start, margin = Dimens.dp100)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                },
            text = stringResource(id = R.string.ask_get_notification),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.sp14,
                textAlign = TextAlign.Start,
                color = Color.White,
            ),
        )
        Text(
            modifier = modifier
                .constrainAs(needNotification) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(forwardImage.start, margin = 16.dp)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                },
            text = stringResource(id = R.string.get_notification),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.sp14,
                textAlign = TextAlign.Start,
                color = Color.White,
            ),
        )
        Icon(
            modifier = Modifier
                .size(Dimens.dp16)
                .constrainAs(forwardImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end, margin = 16.dp)
                },
            painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
            contentDescription = stringResource(id = R.string.image),
            tint = Color.White,
        )
    }
}