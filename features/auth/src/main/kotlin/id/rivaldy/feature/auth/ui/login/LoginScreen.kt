package id.rivaldy.feature.auth.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import id.rivaldy.core.util.Dimens
import id.rivaldy.core.util.UtilStrings
import id.rivaldy.feature.auth.ui.login.sections.LoginContent

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToRegister: () -> Unit,
) {
    Scaffold(
        containerColor = Color.Transparent,
    ) { innerPadding ->
        Surface(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            color = Color.Transparent
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LoginContent(navigateToHome)
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(Dimens.dp20)
                        .clickable {
                            navigateToRegister()
                        },
                    text = UtilStrings.noAccountSpanned(),
                    style = TextStyle(
                        fontSize = Dimens.sp14,
                        fontFamily = FontFamily.Default,
                    ),
                )
            }
        }
    }
}