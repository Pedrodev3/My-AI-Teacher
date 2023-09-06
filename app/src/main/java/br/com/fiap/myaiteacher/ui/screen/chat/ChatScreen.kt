package br.com.fiap.myaiteacher.ui.screen.chat

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.myaiteacher.R
import br.com.fiap.myaiteacher.ui.screen.chat.components.DialogBaloon
import br.com.fiap.myaiteacher.ui.theme.Montserrat

@SuppressLint("UnrememberedMutableState")
@Composable
fun ChatScreen(navController: NavController, chatScreenViewModel: ChatScreenViewModel) {
    val configuration = LocalConfiguration.current
    val items by chatScreenViewModel.commentsList.observeAsState(initial = mutableStateListOf())
    val comment by chatScreenViewModel.comment.observeAsState(initial = "")

    Column() {
        Row(
            modifier = Modifier
                .background(color = Color(0xFF00002E))
                .height((configuration.screenHeightDp * 0.11).dp)
                .width((configuration.screenWidthDp).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.aiteacher),
                contentDescription = "Imagem de um cara",
                modifier = Modifier
                    .size(50.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                modifier = Modifier.width(258.dp),
                text = "Hey exemplo, I am your AI teacher and I am here to help!",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.width(50.dp))
        }
        Spacer(modifier = Modifier.height((configuration.screenHeightDp * 0.002).dp))
        LazyColumn(
            modifier = Modifier
                .background(color = Color(0xFF2C2F34))
                .height((configuration.screenHeightDp * 0.758).dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(space = 56.dp, alignment = Alignment.Bottom),
            contentPadding = PaddingValues(vertical = 30.dp)
        ) {
            items.forEachIndexed { index, item ->
                item {
                    DialogBaloon(index = index, text = item)
                }
            }
        }
        Spacer(modifier = Modifier.height((configuration.screenHeightDp * 0.001).dp))
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
}