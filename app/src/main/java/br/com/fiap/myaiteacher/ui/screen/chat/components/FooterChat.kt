package br.com.fiap.myaiteacher.ui.screen.chat.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.myaiteacher.R
import br.com.fiap.myaiteacher.ui.screen.chat.ChatScreenViewModel
import br.com.fiap.myaiteacher.ui.theme.Montserrat

@Composable
fun FooterChat(configuration: Configuration, comment: String, chatScreenViewModel: ChatScreenViewModel, items: SnapshotStateList<String>) {

    var texto = ""

    Row(
        modifier = Modifier
            .background(color = Color(0xFF2C2F34))
            .height((configuration.screenHeightDp * 0.13).dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = comment,
            onValueChange = {
                chatScreenViewModel.onCommentChanged(it)
            },
            placeholder = {
                Text(text = "What’s your question? ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight(400),
                        color = Color(0xB2FFFFFF),
                    )
                )
            },
            modifier = Modifier
                .width(287.dp)
                .height(55.dp)
                .padding(start = 22.dp),
            shape = RoundedCornerShape(
                12.dp
            ),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
        )
        IconButton(
            onClick = {
                chatScreenViewModel.onAddNewComment(comment)
                chatScreenViewModel.onCommentChanged("")

            },
            modifier = Modifier
                .padding(start = 30.dp, end = 10.dp)
                .width(35.dp)
                .height(35.dp)
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.baseline_send_24),
                contentDescription = "Send message",
                tint = Color(0xB2FFFFFF)
            )
        }
    }
}