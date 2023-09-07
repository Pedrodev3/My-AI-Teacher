package br.com.fiap.myaiteacher.ui.screen


import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.myaiteacher.components.CaixaDeEntrada
import br.com.fiap.myaiteacher.components.CalendarioInput
import br.com.fiap.myaiteacher.components.Filtro
import br.com.fiap.myaiteacher.model.Login
import br.com.fiap.myaiteacher.repository.LoginRepository
import br.com.fiap.myaiteacher.viewmodel.LoginScreenViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    loginScreenViewModel: LoginScreenViewModel
) {
    val context = LocalContext.current
    val loginRepository = LoginRepository(context)

    val nomeState by loginScreenViewModel.nomeState.observeAsState(initial = "")
    val emailState by loginScreenViewModel.emailState.observeAsState(initial = "")
    val instituicaoState by loginScreenViewModel.instituicaoState.observeAsState(initial = "")
    val dateState by loginScreenViewModel.dateState.observeAsState(initial = "")
    val telefoneState by loginScreenViewModel.telefoneState.observeAsState(initial = "")

    val login = Login(
        codigo = 0, // AutoGenerate - O Banco ira gerenciar isso
        nome = loginScreenViewModel.nomeState.value,
        email = loginScreenViewModel.emailState.value,
        instituicao = loginScreenViewModel.instituicaoState.value,
        dataNascimento = loginScreenViewModel.dateState.value,
        telefone = loginScreenViewModel.telefoneState.value,
        realizado = true
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Login",
                    fontSize = 48.sp,
                )
            }
            CaixaDeEntrada(
                nomeValue = nomeState,
                emailValue = emailState,
                instituicaoValue = instituicaoState,
                dateValue = dateState,
                telefoneValue = telefoneState,
                onNomeChange = { loginScreenViewModel.onNomeChange(it) },
                onEmailChange = { loginScreenViewModel.onEmailChange(it) },
                onInstituicaoChange = { loginScreenViewModel.onInstituicaoChange(it) },
                onDateChange = { loginScreenViewModel.onDateChange(it) },
                onTelefoneChange = { loginScreenViewModel.onTelefoneChange(it) },
                modifier = Modifier
            )
        }
        Spacer(modifier = Modifier.height(26.dp))
        Column() {
            Button(onClick = {
                loginRepository.salvar(login)
            }) {
                Text(text = "Entrar")
                IconButton(onClick = {
//                    navController.navigate("login")
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Entrar"
                    )
                }
            }
        }

//        Spacer(modifier = Modifier.height(26.dp))
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Filtro(
//                label = "Filtro e Listagem de usuários",
//                modifier = Modifier,
//            )
//        }
    }
}


