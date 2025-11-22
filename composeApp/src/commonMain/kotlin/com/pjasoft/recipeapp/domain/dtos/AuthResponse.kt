package com.pjasoft.recipeapp.domain.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val message : String,
    val isLogged : Boolean,
    val userId : Int
)
