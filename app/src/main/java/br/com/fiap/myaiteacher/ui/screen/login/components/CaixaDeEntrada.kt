package br.com.fiap.myaiteacher.ui.screen.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
    maxChar : Int
) {
    Column(
        modifier = Modifier
            .heightIn(min = 300.dp)
            .widthIn(max = 320.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        TextField(
            label = {
                Text(
                    text = "Nome:*",
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
                imeAction = ImeAction.Next
            ),
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Nome",
                        tint = colorSecondary
                    )
                }
            },
        )
        TextField(
            label = {
                Text(
                    text = "E-mail:*",
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
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email",
                        tint = colorSecondary
                    )
                }
            }
        )
        CalendarioInput(
            label = "Data de Nascimento:",
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
                imeAction = ImeAction.Done
            ),
            supportingText = {
                             Text(
                                 text = "${telefoneValue.length}/$maxChar",
                                 modifier = Modifier.fillMaxWidth().padding(5.dp),
                                 textAlign = TextAlign.End,
                                    color = colorSecondary
                             )
            },
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = "Instituição de Ensino",
                        tint = colorSecondary
                    )
                }
            }
        )
    }
}