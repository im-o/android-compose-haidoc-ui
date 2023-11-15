package id.rivaldy.core.util

import android.util.Log
import id.rivaldy.core.BuildConfig

/** Created by github.com/im-o on 11/15/2023. */

object UtilFunctions {
    fun logE(message: String) {
        if (BuildConfig.DEBUG) Log.e("ERROR_IMO", message)
    }
}