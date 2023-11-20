package id.rivaldy.feature.home.ui.profile.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        Spacer(modifier = modifier.height(Dimens.dp40))
        ProfileTab(modifier = modifier)
        Spacer(modifier = modifier.height(Dimens.dp40))
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.dp32)
                .shadow(elevation = Dimens.dp16, shape = RoundedCornerShape(Dimens.dp20))
                .background(Color.White, RoundedCornerShape(Dimens.dp20)),
        ) {
            ProfileCard(modifier = modifier)
            Spacer(modifier = modifier.height(Dimens.dp16))
            ProfilePersonalTab(modifier = modifier)
            Spacer(modifier = modifier.height(Dimens.dp16))
            ProfileForm(modifier = modifier)
            Spacer(modifier = modifier.height(Dimens.dp24))
        }
        Spacer(modifier = modifier.height(Dimens.dp60))
    }
}