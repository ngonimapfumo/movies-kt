package zw.co.nm.movieskt.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Retrofit {
    private var retrofit: Retrofit? = null;
    private val baseUrl = "https://yts.mx/api/v2/";


    private fun getClient(): Retrofit? {
        val httpLoggingInterceptor = HttpLoggingInterceptor();
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(Interceptor { chain ->
            val requestBuilder: Request.Builder = chain.request().newBuilder()
            chain.proceed(requestBuilder.build())
        })
        val okHttpClient: OkHttpClient =
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor).build()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit
    }

    fun getService(): ApiService?{
        return getClient()?.create(ApiService::class.java)
    }
}