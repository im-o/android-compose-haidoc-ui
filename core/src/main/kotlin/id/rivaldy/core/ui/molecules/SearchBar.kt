package id.rivaldy.core.ui.molecules

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import id.rivaldy.core.R
import id.rivaldy.core.util.Dimens

/** Created by github.com/im-o on 11/15/2023. */

@Composable
fun SearchBar(
    query: String,
    modifier: Modifier = Modifier,
    isEnabled: (Boolean) = true,
    onSearchClicked: () -> Unit = {},
    onQueryChange: (String) -> Unit = {},
) {
    var isTextFieldFocused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSearchClicked() }
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            enabled = isEnabled,
            modifier = modifier
                .focusRequester(FocusRequester())
                .onFocusChanged { isTextFieldFocused = it.isFocused }
                .fillMaxWidth()
                .heightIn(min = Dimens.dp48, max = Dimens.dp48)
                .clip(shape = RoundedCornerShape(Dimens.dp8))
                .border(
                    border = BorderStroke(Dimens.dp1, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(Dimens.dp8)
                ),
            textStyle = TextStyle(fontSize = Dimens.sp14),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(Dimens.dp20),
                )
            },
            trailingIcon = {
                if (isTextFieldFocused && query.isNotEmpty()) {
                    IconButton(onClick = { onQueryChange("") }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = stringResource(R.string.clear),
                            modifier = Modifier.size(Dimens.dp20),
                        )
                    }
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = MaterialTheme.colorScheme.onSurface,
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.search),
                    fontSize = Dimens.sp14,
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {}),
        )
    }
}