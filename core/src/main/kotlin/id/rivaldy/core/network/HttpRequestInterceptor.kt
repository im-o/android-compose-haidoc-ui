package id.rivaldy.core.network

import id.rivaldy.core.util.UtilFunctions.logE
import okhttp3.Interceptor
import okhttp3.Response

/** Created by github.com/im-o on 11/15/2023. */

internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        logE("HttpRequestInterceptor : $request")
        return chain.proceed(request)
    }
}