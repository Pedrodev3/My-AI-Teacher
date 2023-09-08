package br.com.fiap.myaiteacher.ui.screen.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
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
    colorPrimary: Color,
    colorSecondary: Color,
    modifier: Modifier,
    textStyle: TextStyle,
    textField: TextFieldColors,
    formatting: ((String) -> String)? = null,
) {
    Column(
        modifier = Modifier
            .height(400.dp)
            .widthIn(max = 320.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        TextField(
            label = {
                Text(
                    text = "Nome:",
                    color = colorSecondary,
                )
            },
            value = nomeValue,
            onValueChange = {
                onNomeChange(it)
            },
            modifier = modifier,
            textStyle = textStyle,
            colors = textField,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            )
        )
        TextField(
            label = {
                Text(
                    text = "E-mail:",
                    color = colorSecondary,
                )
            },
            value = emailValue,
            onValueChange = {
                onEmailChange(it)
            },
            modifier = modifier,
            textStyle = textStyle,
            colors = textField,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            )
        )
        TextField(
            label = {
                Text(
                    text = "Instituição de Ensino:",
                    color = colorSecondary,
                )
            },
            value = instituicaoValue,
            onValueChange = {
                onInstituicaoChange(it)
            },
            modifier = modifier,
            textStyle = textStyle,
            colors = textField,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            )
        )
        CalendarioInput(
            label = "Data de Nascimento",
            value = dateValue,
            onValueChange = { onDateChange(it) },
            modifier = modifier,
            textStyle = textStyle,
            textField = textField,
            colorPrimary = colorPrimary,
            colorSecondary = colorSecondary,
        )
        TextField(
            label = {
                Text(
                    text = "Telefone:",
                    color = colorSecondary,
                )
            },
            placeholder = {
                Text(
                    text = "DDD + Número",
                    color = colorSecondary
                )
            },
            value = telefoneValue,
            onValueChange = {
                onTelefoneChange(it)
            },
            modifier = modifier,
            textStyle = textStyle,
            colors = textField,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
            )
        )
    }
}