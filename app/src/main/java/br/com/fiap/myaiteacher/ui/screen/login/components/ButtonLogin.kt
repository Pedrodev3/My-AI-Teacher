package br.com.fiap.myaiteacher.ui.screen.login.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonLogin(
    text: String,
    onClick: () -> Unit

) {
    val backgroundColor = Color(0xFF3646fe)

    Button(
        onClick = onClick,
        modifier = Modifier
            .size(280.dp, 50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            color = Color.White
        )
    }

}