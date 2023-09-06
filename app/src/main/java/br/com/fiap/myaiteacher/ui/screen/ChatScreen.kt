package br.com.fiap.myaiteacher.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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

    Column() {
        Row(
            modifier = Modifier
                .background(color = Color(0xFF00002E))
                .height((configuration.screenHeightDp * 0.09).dp)
                .fillMaxWidth()
        ) {

        }
        Spacer(modifier = Modifier.height((configuration.screenHeightDp * 0.001).dp))
        Column(
            modifier = Modifier
                .background(color = Color(0xFF2C2F34))
                .height((configuration.screenHeightDp * 0.778).dp)
                .fillMaxWidth()
        ) {

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
                onClick = { Log.i("Oi", "SSSSSSSS")},
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