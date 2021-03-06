package com.example.heart_to_heart.infrastructure.network.post_api

import com.example.heart_to_heart.application.Constants.Companion.BASE_URL
import com.example.heart_to_heart.data.repository.dataSource.remote.PostAPI
import com.example.heart_to_heart.infrastructure.network.interceptor.AuthInterceptor
import com.example.heart_to_heart.infrastructure.network.post_api.service.PostService
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DefaultPostsAPI
constructor(
    private val authInterceptor: AuthInterceptor
) : PostAPI {

    override fun getPostService(): PostService {
        val okHttpClient = OkHttpClient.Builder()
            // .addNetworkInterceptor(authInterceptor)
            .addInterceptor(authInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PostService::class.java)
        return service
    }
}
