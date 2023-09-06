package br.com.fiap.myaiteacher.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.myaiteacher.R
import br.com.fiap.myaiteacher.ui.theme.Montserrat

@Composable
fun ChatScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

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
            verticalArrangement = Arrangement.Bottom,
        ) {
            items.forEachIndexed { index, item ->
                val alignment = if (index % 2 == 0) CenterStart else CenterEnd
                val color = if (index % 2 == 0) Color(0xFF3D4045) else Color(0xFFD292FE)
                val secondColor = if (index % 2 == 0) Color(0xFFFFFFFF) else Color(0xFF00002E)
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        contentAlignment = alignment
                    ) {
                        BoxWithConstraints(
                            modifier = Modifier
                                .background(color = color, shape = RoundedCornerShape(size = 8.dp))
                                .border(color = secondColor, width = 0.5.dp, shape = RoundedCornerShape(size = 8.dp))
                            )
                        {
                            Text(
                                text = item,
                                style = TextStyle(
                                    textAlign = TextAlign.Center,
                                    color = secondColor
                                ),
                                modifier = Modifier
                                    .padding(5.dp)
                                    .widthIn(max = 260.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(56.dp))
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
                value = "",
                onValueChange = {},
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
            )
            IconButton(
                onClick = {},
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


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewApp() {
    val navController = rememberNavController()
    ChatScreen(navController = navController)
}