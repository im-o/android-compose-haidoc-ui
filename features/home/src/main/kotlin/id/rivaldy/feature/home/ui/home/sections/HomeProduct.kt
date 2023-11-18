package id.rivaldy.feature.home.ui.home.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/18/2023. */

@Composable
fun HomeProduct(
    modifier: Modifier = Modifier,
) {
    val products = listOf("Suntik Steril", "Microscope", "Sunting Sapi", "Obat Flue")
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Dimens.dp16),
        contentPadding = PaddingValues(start = Dimens.dp16, end = Dimens.dp16),
    ) {
        items(count = products.size) { index ->
            HomeProductItem(
                modifier = modifier,
                productName = products[index],
            )
        }
    }
}

@Composable
fun HomeProductItem(
    modifier: Modifier = Modifier,
    productName: String,
) {
    ConstraintLayout(
        modifier = modifier
            .width(Dimens.dp150)
            .wrapContentHeight()
            .shadow(elevation = Dimens.dp3, shape = RoundedCornerShape(Dimens.dp16))
            .background(color = Color.White, shape = RoundedCornerShape(Dimens.dp16)),
    ) {
        val (image, rating, ratingCount, title, price, status) = createRefs()
        Image(
            modifier = modifier
                .size(80.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top, margin = 25.dp)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    centerHorizontallyTo(parent)
                },
            painter = painterResource(id = R.drawable.microscope),
            contentDescription = stringResource(id = R.string.image),
        )
        Text(
            modifier = modifier
                .constrainAs(ratingCount) {
                    top.linkTo(parent.top, margin = 10.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                },
            text = "5",
            style = TextStyle(
                color = Color.Gray.copy(alpha = 0.5f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.sp16,
            )
        )
        Image(
            modifier = modifier
                .size(Dimens.dp16)
                .constrainAs(rating) {
                    top.linkTo(parent.top, margin = 10.dp)
                    end.linkTo(ratingCount.start, margin = 1.dp)
                },
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = stringResource(id = R.string.image),
        )
        Text(
            modifier = modifier
                .constrainAs(title) {
                    top.linkTo(image.bottom, margin = 12.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                },
            text = productName,
            style = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.sp14,
            )
        )
        Text(
            modifier = modifier
                .constrainAs(price) {
                    top.linkTo(title.bottom, margin = 8.dp)
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                },
            text = "Rp. 10.000",
            style = TextStyle(
                color = colorResource(id = R.color.orange),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.sp12,
            )
        )
        Box(
            modifier = modifier
                .wrapContentWidth()
                .background(
                    color = colorResource(id = R.color.green_300),
                    shape = RoundedCornerShape(Dimens.dp5),
                )
                .constrainAs(status) {
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                },
        ) {
            Text(
                modifier = modifier
                    .padding(vertical = Dimens.dp3, horizontal = Dimens.dp5),
                text = "Ready Stok",
                style = TextStyle(
                    color = colorResource(id = R.color.green_700),
                    textAlign = TextAlign.Center,
                    fontSize = Dimens.sp10,
                )
            )
        }
    }
}