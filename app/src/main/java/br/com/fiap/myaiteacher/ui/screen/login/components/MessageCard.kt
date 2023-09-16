package br.com.fiap.myaiteacher.ui.screen.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageCard(
    message: String,
    icon: ImageVector,
    backgroundColor: Color,
    modifier: Modifier,
    duration: Long
) {
    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current.density

//    val colorPrimary = Color(0xFFD292FE)
//    val colorSecondary = Color(0xFF00002E)

    LaunchedEffect(Unit) {
        delay(duration)
        visible = false
    }

    if (visible) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(color = backgroundColor),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = message,
                    color = Color.White,
                    fontSize = 16.sp,
                    maxLines = 2,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
