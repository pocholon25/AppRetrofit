package com.example.appprueba.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appprueba.core.ruta.RutaPatitas

@Composable
fun registroScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            cabecera()
            formularioRegistrate()
            IrLogin(navController)

        }
    }
}

@Composable
fun cabecera() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = Icons.Filled.Pets,
            contentDescription = "logo de Patitas",
            Modifier
                .width(100.dp)
                .height(100.dp)
        )
        Text(text = "REGISTRATE", fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun formularioRegistrate() {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        txtnombre("") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txtapellido("") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txteamail("") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txtceñular("") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txtusuarioreg("") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txtpasswordreg("") { it }
        Spacer(modifier = Modifier.size(10.dp))
        authButtonreg()
    }
}

@Composable
fun txtnombre(nombre: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = nombre,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Nombre") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "persona",
                tint = Color.Blue
            )
        },
        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun txtapellido(apellido: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = apellido,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Apellido")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "persona",
                tint = Color.Blue
            )
        },
        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun txteamail(email: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Email")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "persona",
                tint = Color.Blue
            )
        },

        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun txtceñular(celular: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = celular,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Celular")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "persona",
                tint = Color.Blue
            )
        },
        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun txtusuarioreg(usuario: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = usuario,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Usuario")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "persona",
                tint = Color.Blue
            )
        },
        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun txtpasswordreg(password: String, onTextChanged: (String) -> Unit) {
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Key,
                contentDescription = "persona",
                tint = Color.Blue
            )
        },
        trailingIcon = {
            val imagen = if (visible) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { visible = !visible }) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        }, visualTransformation = if (visible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun authButtonreg() {
    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Registrarse")
    }
}

@Composable
fun IrLogin(navController: NavController) {
    Spacer(modifier = Modifier.height(24.dp))

    HorizontalDivider(
        Modifier
            .height(1.dp)
            .fillMaxWidth(), color = Color.Blue)

    Spacer(modifier = Modifier.height(16.dp))

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Inicia Sesión",
            fontSize = 14.sp,
            color = Color(0xFF2196F3),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable { navController.navigate(RutaPatitas.loginScreen.path) }
                .padding(8.dp)
        )
    }
}


