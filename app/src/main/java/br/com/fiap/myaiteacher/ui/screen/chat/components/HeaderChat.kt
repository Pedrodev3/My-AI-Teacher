package br.com.fiap.myaiteacher.ui.screen.chat.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.myaiteacher.R
import br.com.fiap.myaiteacher.ui.screen.login.LoginScreenViewModel
import br.com.fiap.myaiteacher.ui.theme.Montserrat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HeaderChat(configuration: Configuration, drawerState: DrawerState, scope: CoroutineScope, nameState: String?) {
    Row(
        modifier = Modifier
            .background(color = Color(0xFF00002E))
            .height((configuration.screenHeightDp * 0.11).dp)
            .width((configuration.screenWidthDp).dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(
            onClick = {
                scope.launch {
                    drawerState.open()
                }
            },
            modifier = Modifier
                .width(35.dp)
                .height(35.dp)
        )
        {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Open App Menu",
                tint = Color(0xB2FFFFFF)
            )
        }
        Text(
            modifier = Modifier.width(248.dp),
            text = "Hey $nameState, I am your AI teacher and I am here to help!",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center
            )
        )
        Image(
            painter = painterResource(id = R.drawable.aiteacher),
            contentDescription = "Imagem de um cara",
            modifier = Modifier
                .size(50.dp),
            contentScale = ContentScale.Crop
        )
    }
}