package id.rivaldy.feature.auth.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import id.rivaldy.feature.auth.ui.login.sections.LoginSection

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
                LoginSection(navigateToHome = navigateToHome, navigateToForm = navigateToRegister)
            }
        }
    }
}