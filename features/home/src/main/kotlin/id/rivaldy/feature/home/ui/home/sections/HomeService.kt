package id.rivaldy.feature.home.ui.home.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/18/2023. */

@Composable
fun HomeService(
    modifier: Modifier = Modifier,
) {
    val services = listOf(
        "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
        "Pemeriksaan untuk Ibu dan Anak",
        "Operasi mata katarak untuk Lansia (S&K)",
    )
    val cardSize = Dimens.dp150
    val itemSize = services.size
    val spacedBy = Dimens.dp16
    val heightLazyColumn = (cardSize.value * itemSize) + (spacedBy.value * itemSize)
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .height(heightLazyColumn.dp),
        verticalArrangement = Arrangement.spacedBy(spacedBy),
        contentPadding = PaddingValues(start = Dimens.dp16, end = Dimens.dp16),
    ) {
        items(count = itemSize) { index ->
            ServiceItem(
                modifier = modifier,
                serviceName = services[index],
                cardSize = cardSize,
            )
        }
    }
}

@Composable
fun ServiceItem(
    modifier: Modifier = Modifier,
    serviceName: String,
    cardSize: Dp,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(cardSize)
            .shadow(elevation = Dimens.dp3, shape = RoundedCornerShape(Dimens.dp16))
            .background(color = Color.White, shape = RoundedCornerShape(Dimens.dp16)),
    ) {
        val (title, price, image, place, location) = createRefs()
        Text(
            modifier = modifier
                .constrainAs(title) {
                    top.linkTo(parent.top, margin = 12.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(image.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                },
            text = serviceName,
            style = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.sp16,
            )
        )
        Text(
            modifier = modifier
                .constrainAs(price) {
                    top.linkTo(title.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(image.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                },
            text = "Rp. 10.000",
            style = TextStyle(
                color = colorResource(id = R.color.orange),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.sp14,
            )
        )
        Row(
            modifier = modifier
                .constrainAs(place) {
                    top.linkTo(price.bottom, margin = 20.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(image.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                modifier = Modifier.size(Dimens.dp14),
                painter = painterResource(id = R.drawable.ic_hospital),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = modifier.width(Dimens.dp8))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.dummy_place),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = Dimens.sp14,
                    textAlign = TextAlign.Start,
                    color = Color.Gray,
                ),
            )
        }
        Row(
            modifier = modifier
                .constrainAs(location) {
                    top.linkTo(place.bottom, margin = 8.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(image.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                modifier = Modifier.size(Dimens.dp14),
                painter = painterResource(id = R.drawable.ic_marker),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = modifier.width(Dimens.dp8))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.dummy_location),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = Dimens.sp12,
                    textAlign = TextAlign.Start,
                    color = Color.Gray,
                ),
            )
        }
        Image(
            modifier = modifier
                .height(150.dp)
                .width(120.dp)
                .clip(shape = RoundedCornerShape(Dimens.dp16))
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.hotel),
            contentDescription = stringResource(id = R.string.image),
        )
    }
}