package id.rivaldy.core.util

import android.content.Context
import android.widget.Toast

/** Created by github.com/im-o on 11/16/2023. */

object UtilExtensions {
    fun Context.myToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}