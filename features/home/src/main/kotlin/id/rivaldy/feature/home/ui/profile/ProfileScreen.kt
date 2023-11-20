package id.rivaldy.feature.home.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.rivaldy.feature.home.ui.components.Footer
import id.rivaldy.feature.home.ui.profile.sections.ProfileSection

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        ProfileSection(modifier = modifier)
        Footer(modifier = modifier)
    }
}