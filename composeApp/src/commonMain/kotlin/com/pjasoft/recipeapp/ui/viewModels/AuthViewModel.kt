package com.pjasoft.recipeapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pjasoft.recipeapp.data.ktorfitClient
import com.pjasoft.recipeapp.domain.dtos.Login
import com.pjasoft.recipeapp.domain.dtos.Register
import com.pjasoft.recipeapp.domain.utils.Preferences
import de.jensklingenberg.ktorfit.ktorfit
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel(){
    fun register(
        name : String,
        email : String,
        password : String,
        onResult: (Boolean, String) -> Unit
    ){
        viewModelScope.launch {
            try {
                val service = ktorfitClient.createAuthService()
                val register = Register(
                    name = name,
                    email = email,
                    password = password
                )
                val result = service.register(register)
                if(result.isLogged){
                    println("Logueado")
                    Preferences.saveUserId(result.userId)
                    Preferences.saveIsLogged(result.isLogged)
                    onResult(true,result.message)
                    println(result.toString())
                }else{
                    onResult(false,result.message)
                    println("No logueao")
                    println(result.toString())
                }
            }catch (e : Exception){
                onResult(false, "Error al reistrarte")
                print(e.toString())
            }
        }
    }

    fun login(
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ){
        viewModelScope.launch {
            try {
                val service = ktorfitClient.createAuthService()
                val login = Login(
                    email = email,
                    password = password
                )
                val result = service.login(login)
                if (result.isLogged){
                    Preferences.saveUserId(result.userId)
                    Preferences.saveIsLogged(result.isLogged)
                    onResult(true, result.message)
                }
                else{
                    onResult(false, result.message )
                }
            }
            catch (e :  Exception){
                onResult(false, "Error al loguearse")
            }
        }
    }

}