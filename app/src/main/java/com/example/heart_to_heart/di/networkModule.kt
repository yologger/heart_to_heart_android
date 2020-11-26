package com.example.heart_to_heart.di

import com.example.heart_to_heart.data.repository.dataSource.remote.AuthorizationAPI
import com.example.heart_to_heart.data.repository.dataSource.remote.PostsAPI
import com.example.heart_to_heart.infrastructure.network.interceptor.AuthInterceptor
import com.example.heart_to_heart.infrastructure.network.authoriztion.DefaultAuthorizationAPI
import com.example.heart_to_heart.infrastructure.network.post.DefaultPostsAPI
import org.koin.dsl.module

val BASE_URL = "http://10.0.2.2:8000"
val AUTHORIZATION_BASE_URL = "http://127.0.0.1:8000"


var networkModule = module {
    single<AuthorizationAPI> { DefaultAuthorizationAPI(get()) }
    single<PostsAPI>{ DefaultPostsAPI(get()) }
    factory { AuthInterceptor(get()) }
}