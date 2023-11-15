package id.rivaldy.core.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import id.rivaldy.core.R

/** Created by github.com/im-o on 11/15/2023. */

object UtilStrings {
    @Composable
    fun noAccountSpanned() = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black)) {
            append("${stringResource(id = R.string.no_account)} ")
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
            )
        ) {
            append(stringResource(id = R.string.register_now))
        }
    }
}