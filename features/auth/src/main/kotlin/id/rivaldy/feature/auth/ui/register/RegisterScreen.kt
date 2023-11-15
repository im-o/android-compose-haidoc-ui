package id.rivaldy.feature.auth.ui.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import id.rivaldy.feature.auth.ui.register.sections.RegisterSection

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit,
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
                RegisterSection(navigateToHome = navigateToHome, navigateToForm = navigateToLogin)
            }
        }
    }
}