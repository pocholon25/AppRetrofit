package com.example.appprueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appprueba.auth.view.LoginScreen
import com.example.appprueba.ui.theme.AppPruebaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppPruebaTheme {
                LoginScreen()
            }
        }
    }
}

