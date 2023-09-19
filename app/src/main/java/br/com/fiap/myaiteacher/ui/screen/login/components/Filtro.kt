package br.com.fiap.myaiteacher.ui.screen.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.myaiteacher.model.login.Login
import br.com.fiap.myaiteacher.repository.login.LoginRepository


@Composable
fun Filtro(
    label: String,
    modifier: Modifier,
) {
    val context = LocalContext.current
    val loginRepository = LoginRepository(context)

    val listaLoginState = remember {
        mutableStateOf(listOf<Login>())
    }
    listaLoginState.value = loginRepository.exibirLoginsRealizados(true)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = "",
            onValueChange = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp),
            label = {
                Text(text = label)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            )
        )
        IconButton(onClick = {}, modifier = Modifier
            .offset(
                x = 170.dp,
                y = (-50).dp
            )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Entrar",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        ListaDeLogins(listaLoginState)
    }
}

@Composable
fun ListaDeLogins(listaLoginState: MutableState<List<Login>>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (usuarioLogin in listaLoginState.value) {
            LoginCard(usuarioLogin)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun LoginCard(usuarioLogin: Login?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(2f)
            ) {
                if (usuarioLogin != null) {
                    Text(
                        text = usuarioLogin.nome ?: "",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                if (usuarioLogin != null) {
                    Text(
                        text = usuarioLogin.email ?: "",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                if (usuarioLogin != null) {
                    Text(
                        text = usuarioLogin.instituicao ?: "",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                if (usuarioLogin != null) {
                    Text(
                        text = usuarioLogin.dataNascimento ?: "",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                if (usuarioLogin != null) {
                    Text(
                        text = usuarioLogin.telefone ?: "",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}