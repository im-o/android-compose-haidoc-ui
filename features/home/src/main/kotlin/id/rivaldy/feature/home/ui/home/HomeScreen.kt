package id.rivaldy.feature.home.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimens.dp60),
    ) {
        Text(
            modifier = modifier.align(Alignment.Center),
            text = "Halaman Home [on progress], Profile pun [on progress]. maaf kehabisan waktu, terimakasih."
        )
    }
}