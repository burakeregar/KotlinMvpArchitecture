package com.base.di.module

import android.app.Application
import dagger.Module
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Burak Eregar on 5.06.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
@Module
class OkHttpModule {
    private fun getBaseBuilder(cache: Cache): OkHttpClient.Builder {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .cache(cache)
                .retryOnConnectionFailure(true)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
    }

    private class CachingControlInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {

            val requestBuilder = chain.request().newBuilder()
            val cacheControl = CacheControl.Builder()
                    .maxStale(1, TimeUnit.MINUTES)
                    .maxAge(1, TimeUnit.MINUTES)
                    .build()

            requestBuilder.cacheControl(cacheControl)
            requestBuilder.header("Content-Type", "application/json")
            val request = requestBuilder.build()

            val originalResponse = chain.proceed(request)
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=604800")
                    .build()
        }
    }

    @Provides
    @Singleton
    fun providesOkHttpCache(pApplication: Application): Cache =
            Cache(pApplication.cacheDir, 10 * 1024 * 1024)

    @Provides
    @Singleton
    fun providesLogginInterceptor() : HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun providesOkHttp(cache: Cache, loggingInterceptor: HttpLoggingInterceptor) = getBaseBuilder(cache)
            .addNetworkInterceptor(CachingControlInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
}
