package br.com.fiap.myaiteacher.ui.screen.bookmarks.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.myaiteacher.ui.theme.Montserrat

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun DialogSaved(index: Int, text: String) {

    val alignment = if (index % 2 != 0) Alignment.CenterStart else Alignment.CenterEnd
    val color = if (index % 2 != 0) Color(0xFF3D4045) else Color(0xFFD292FE)
    val secondColor = if (index % 2 != 0) Color(0xFFFFFFFF) else Color(0xFF00002E)

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
                text = text,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = secondColor,
                    fontSize = 14.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight(400),
                ),
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 5.dp)
                    .widthIn(max = 260.dp)
            )
        }
    }
}