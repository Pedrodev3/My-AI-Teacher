package br.com.fiap.myaiteacher.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    Column {
        Text(text = "Login",
            fontSize = 48.sp)
    }
}