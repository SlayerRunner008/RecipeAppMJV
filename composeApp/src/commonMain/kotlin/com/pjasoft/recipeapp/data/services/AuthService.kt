package com.pjasoft.recipeapp.data.services

import com.pjasoft.recipeapp.domain.dtos.AuthResponse
import com.pjasoft.recipeapp.domain.dtos.Login
import com.pjasoft.recipeapp.domain.dtos.Register
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.POST

interface AuthService {

    @POST("auth/register")
    suspend fun register (@Body register: Register) : AuthResponse

    @POST("auth/login")
    suspend fun login(@Body login: Login) : AuthResponse
}