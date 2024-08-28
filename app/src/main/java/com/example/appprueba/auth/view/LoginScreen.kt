package com.example.appprueba.auth.view

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Cabecera(modifier = Modifier.align(Alignment.TopEnd))
            Pie(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Composable
fun Cabecera(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Cerrar",
        modifier = modifier.clickable { activity.finish() })
}

@Composable
fun Pie(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            Modifier
                .background(Color(0x0F27861C))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        IrRegistro()
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun IrRegistro() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "¿ No tienes cuenta ? ", fontSize = 12.sp, color = Color(0xFFCDDC39))
        Text(
            text = " Registrate aqui",
            fontSize = 12.sp,
            color = Color(0xFF2196F3),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { Log.i("TextClick", "Hola Texto") })
    }
}

@Composable
fun FormularioLogin(modifier: Modifier) {
    Column(modifier = modifier.padding(start = 5.dp, end = 5.dp)) {

    }
}

@Composable
fun txtusuario(usuario: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = usuario,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Usuario")
        },
        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun txtpassword(password: String, onTextChanged: (String) -> Unit) {
    var visible by rememberSaveable {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(
                text = "Password"
            )
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if (visible) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { visible = !visible }) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        },visualTransformation = if (visible) {
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()
        }
    )
}




