package com.jeongsejong.search.network

import android.content.Context
import com.jeongsejong.search.app.AppConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by jeongsejong on 2022/06/06
 */
class ApiProvider {

    fun <S> createService(serviceClass: Class<S>, context: Context): S {
        val retrofit = Retrofit.Builder()
                .baseUrl(AppConstant.KAKAO_SEARCH_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()

        return retrofit.create(serviceClass)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                val request = requestBuilder.build()
                chain.proceed(request)
            }.connectTimeout(5000L, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .hostnameVerifier { hostname, session -> true }
            .retryOnConnectionFailure(true)
            .build()

        return okHttpClient
    }


}