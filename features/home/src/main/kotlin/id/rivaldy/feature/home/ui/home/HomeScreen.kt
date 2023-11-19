package id.rivaldy.feature.home.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.rivaldy.core.util.Dimens
import id.rivaldy.feature.home.ui.components.Footer
import id.rivaldy.feature.home.ui.home.sections.HomeSection

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        HomeSection(modifier = modifier)
        Spacer(modifier = modifier.height(Dimens.dp60))
        Footer(modifier = modifier)
    }
}