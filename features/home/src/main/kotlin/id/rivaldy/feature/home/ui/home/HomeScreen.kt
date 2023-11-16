package id.rivaldy.feature.home.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import id.rivaldy.core.util.Dimens
import id.rivaldy.feature.home.ui.home.sections.HomeSection

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        HomeSection()
        Spacer(modifier = modifier.height(Dimens.dp32))
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(Dimens.dp60),
        ) {
            Text(
                modifier = modifier.align(Alignment.Center),
                text = "Halaman Home [on progress], Profile pun [on progress]. maaf kehabisan waktu, terimakasih."
            )
        }
    }
}