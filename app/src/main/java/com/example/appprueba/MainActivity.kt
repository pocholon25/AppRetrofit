package com.example.appprueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appprueba.auth.view.LoginScreen
import com.example.appprueba.auth.view.registroScreen
import com.example.appprueba.auth.viewmodel.LoginViewModel
import com.example.appprueba.auth.viewmodel.RegistroViewModel
import com.example.appprueba.core.ruta.RutaPatitas
import com.example.appprueba.home.view.homeScreen
import com.example.appprueba.ui.theme.AppPruebaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private val registroViewModel: RegistroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppPruebaTheme {
                val navigation = rememberNavController()

                NavHost(navController = navigation, startDestination = RutaPatitas.loginScreen.path, builder = {
                    composable(RutaPatitas.loginScreen.path){
                        LoginScreen(loginViewModel,navigation)
                    }
                    composable(RutaPatitas.registroScreen.path){
                        registroScreen(navigation, registroViewModel)
                    }
                    composable(RutaPatitas.homeScreen.path){
                        homeScreen()
                    }
                })
            }
        }
    }
}

