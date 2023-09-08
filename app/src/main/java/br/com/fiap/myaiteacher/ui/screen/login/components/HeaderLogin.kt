package br.com.fiap.myaiteacher.ui.screen.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.fiap.myaiteacher.ui.theme.Montserrat
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit


@Composable
fun HeaderLogin(
    text1: String,
    text2: String,
    fontSize: TextUnit,
    fontFamily: androidx.compose.ui.text.font.FontFamily,
    colorPrimary: Color,
    painter: Painter,
    contentDescription: String
) {
   Column {
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .height(300.dp)
               .padding(start = 35.dp, end = 5.dp),
           horizontalArrangement = Arrangement.SpaceEvenly,
           verticalAlignment = Alignment.CenterVertically,
       ) {
           Image(
               painter = painter,
               contentDescription = contentDescription,
               modifier = Modifier
                   .size(150.dp),
               contentScale = ContentScale.Crop
           )

           Column(
               modifier = Modifier,
               verticalArrangement = Arrangement.Bottom,
           ) {
               Spacer(modifier = Modifier.height(15.dp))
               Text(
                   text = text1,
                   style = TextStyle(
                       fontSize = fontSize,
                       fontFamily = fontFamily,
                       color = colorPrimary
                   ),
                   modifier = Modifier
                       .width(200.dp)
                       .offset(0.dp, (25).dp)
               )
               Spacer(modifier = Modifier.height(1.dp))
               Text(
                   text = text2,
                   style = TextStyle(
                       fontSize = fontSize,
                       fontFamily = fontFamily,
                       color = colorPrimary
                   ),
                   modifier = Modifier
                       .width(200.dp)
                       .offset(0.dp, (20).dp)
               )
           }

       }
   }
}