package com.example.heart_to_heart.infrastructure.network.authoriztion_api.service.token

import com.example.heart_to_heart.infrastructure.network.authoriztion_api.service.token.model.RefreshTokenRequest
import com.example.heart_to_heart.infrastructure.network.authoriztion_api.service.token.model.RefreshTokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenService {
    @POST("/auth/token")
    fun refreshToken(@Body request: RefreshTokenRequest): Call<RefreshTokenResponse>
}

