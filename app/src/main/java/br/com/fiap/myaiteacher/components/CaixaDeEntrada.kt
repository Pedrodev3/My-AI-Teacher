package br.com.fiap.myaiteacher.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeEntrada(
    nomeValue: String,
    emailValue: String,
    instituicaoValue: String,
    dateValue: String,
    telefoneValue: String,
    onNomeChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onInstituicaoChange: (String) -> Unit,
    onDateChange: (String) -> Unit,
    onTelefoneChange: (String) -> Unit,
    modifier: Modifier,
    formatting: ((String) -> String)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            label = {
                Text(text = "Nome:")
            },
            value = nomeValue,
            onValueChange = { onNomeChange(it) },
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            label = {
                Text(text = "E-mail:")
            },
            value = emailValue,
            onValueChange = { onEmailChange(it) },
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            label = {
                Text(text = "Instituição de Ensino:")
            },
            value = instituicaoValue,
            onValueChange = { onInstituicaoChange(it) },
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        CalendarioInput(
            label = "Data de Nascimento",
            value = dateValue,
            onValueChange = { onDateChange(it) },
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            label = {
                Text(text = "Telefone:")
            },
            placeholder = {
                Text(text = "DDD + Número")
            },
            value = telefoneValue,
            onValueChange = { onTelefoneChange(it) },
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            )
        )
    }
}
