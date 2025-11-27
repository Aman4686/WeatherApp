package com.example.data.di

import com.example.data.api.WeatherApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Named("API_KEY")
    fun providesApiKey(): String = "AIzaSyDqrnq4cIEqeUKbQJPd2gyU4XDgqpLWK_c"

    @Provides
    @Named("BASE_URL")
    fun providesBaseUrl(): String = "https://weather.googleapis.com/v1/"

    @Provides
    @Singleton
    fun provideOkHttpClient(@Named("API_KEY") WEATHER_API_KEY: String): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val url = originalRequest.url.newBuilder()
                    .addQueryParameter("key", WEATHER_API_KEY)
                    .build()
                val newRequest = originalRequest.newBuilder().url(url).build()
                chain.proceed(newRequest)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("BASE_URL") BASE_URL: String, client: OkHttpClient): Retrofit {
        val gson = GsonBuilder()
            .create()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit : Retrofit): WeatherApi = retrofit.create(
        WeatherApi::class.java)
}