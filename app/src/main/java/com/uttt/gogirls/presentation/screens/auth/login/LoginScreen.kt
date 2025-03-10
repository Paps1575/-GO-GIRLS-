package com.uttt.gogirls.presentation.screens.auth.login

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.uttt.gogirls.presentation.screens.auth.login.components.LoginContent


@Composable
fun LoginScreen(navController: NavHostController) {


    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    ) { paddingValues ->
        LoginContent(navController=navController,paddingValues=paddingValues)
    }
}
