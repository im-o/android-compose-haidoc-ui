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
        withStyle(
            style = SpanStyle(
                color = Color.Gray.copy(alpha = 0.4f),
                fontWeight = FontWeight.Medium
            )
        ) {
            append("${stringResource(id = R.string.no_account)}  ")
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.ExtraBold,
            )
        ) {
            append(stringResource(id = R.string.register_now))
        }
    }

    @Composable
    fun haveAccountSpanned() = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Gray.copy(alpha = 0.4f),
                fontWeight = FontWeight.Medium
            )
        ) {
            append("${stringResource(id = R.string.have_account)}  ")
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.ExtraBold,
            )
        ) {
            append(stringResource(id = R.string.login_now))
        }
    }

    @Composable
    fun welcomeSpanned() = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            )
        ) {
            append("${stringResource(id = R.string.hi)} ")
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.ExtraBold,
            )
        ) {
            append(stringResource(id = R.string.welcome))
        }
    }

    @Composable
    fun titleSliderSpanned() = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            )
        ) {
            append("${stringResource(id = R.string.solution)} ")
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.ExtraBold,
            )
        ) {
            append(stringResource(id = R.string.your_health))
        }
    }
}