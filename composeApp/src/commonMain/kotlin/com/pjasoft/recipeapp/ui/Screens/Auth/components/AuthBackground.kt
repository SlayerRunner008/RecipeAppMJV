package com.pjasoft.recipeapp.ui.Screens.Auth.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun AuthBackground(
    content : @Composable () -> Unit
){
    Box(){
        content
    }
}

@Composable
fun CustomCard(content: @Composable () -> Unit, onClick : () -> Unit){
    Column {
        content
    }
}

//@Composable
//fun Register{
//    AuthBackground {
//        //card
//        CustomCard(
//            onClick = {},
//            content = {
//                OutLin
//            }
//        )
//    }
//}