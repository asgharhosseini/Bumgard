package ir.ah.app.bumgard.di

import ir.ah.app.bumgard.data.local.sharedpreferences.*
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationHeaderInterceptor @Inject constructor(
    private val userSP: UserInfoManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request().newBuilder()
        if (userSP.getToken()!!.isNotEmpty()) {
            originalRequest.addHeader(
                "Authorization",
                "Bearer ${userSP.getToken()}"
            )
        }
        val newRequest = originalRequest.build()
        return chain.proceed(newRequest)
    }
}