package br.com.fiap.myaiteacher.ui.screen.login


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.myaiteacher.R
import br.com.fiap.myaiteacher.model.login.Login
import br.com.fiap.myaiteacher.repository.login.LoginRepository
import br.com.fiap.myaiteacher.ui.screen.login.components.ButtonLogin
import br.com.fiap.myaiteacher.ui.screen.login.components.CaixaDeEntrada
import br.com.fiap.myaiteacher.ui.screen.login.components.HeaderLogin
import br.com.fiap.myaiteacher.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    loginScreenViewModel: LoginScreenViewModel,
    scrollState: LazyListState
) {
    val context = LocalContext.current
    val loginRepository = LoginRepository(context)
    val nomeState by loginScreenViewModel.nomeState.observeAsState(initial = "")
    val emailState by loginScreenViewModel.emailState.observeAsState(initial = "")
    val instituicaoState by loginScreenViewModel.instituicaoState.observeAsState(initial = "")
    val dateState by loginScreenViewModel.dateState.observeAsState(initial = "")
    val telefoneState by loginScreenViewModel.telefoneState.observeAsState(initial = "")

    val colorPrimary = Color(0xFFD292FE)
    val colorSecondary = Color(0xFF00002E)
    val fontSize = 20.sp


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorSecondary),
        horizontalAlignment = Alignment.CenterHorizontally,
//        state = scrollState
    ) {
        item {
            HeaderLogin(
                text1 = "My AI",
                text2 = "Teacher",
                fontSize = 40.sp,
                fontFamily = Montserrat,
                colorPrimary = colorPrimary,
                painter = painterResource(id = R.drawable.aiteacher),
                contentDescription = "Imagem de um cara"
            )
        }
        item {
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
                colorPrimary = colorPrimary,
                colorSecondary = colorSecondary,
                modifier = Modifier
                    .widthIn(max = 320.dp)
                    .background(color = colorPrimary, shape = RoundedCornerShape(percent = 40))
                    .clip(RoundedCornerShape(percent = 40)),
                textStyle = TextStyle(
                    color = colorSecondary,
                    fontFamily = Montserrat,
                    fontSize = fontSize
                ),
                textField = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorPrimary
                ),
            )
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
        }
        item {
            ButtonLogin(
                text = "Entrar",
                onClick = {
                    val login = Login(
                        codigo = 0, // AutoGenerate - O Banco ira gerenciar isso
                        nome = loginScreenViewModel.nomeState.value,
                        email = loginScreenViewModel.emailState.value,
                        instituicao = loginScreenViewModel.instituicaoState.value,
                        dataNascimento = loginScreenViewModel.dateState.value,
                        telefone = loginScreenViewModel.telefoneState.value,
                        realizado = true
                    )
                    loginRepository.salvar(login)
                    navController.navigate("chat")
                },
            )
        }
    }
}


