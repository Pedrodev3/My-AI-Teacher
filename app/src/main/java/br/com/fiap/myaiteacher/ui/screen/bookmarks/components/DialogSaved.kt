package br.com.fiap.myaiteacher.ui.screen.bookmarks.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import br.com.fiap.myaiteacher.model.bookmark.Bookmark
import br.com.fiap.myaiteacher.ui.screen.bookmarks.BookmarksScreenViewModel
import br.com.fiap.myaiteacher.ui.theme.Montserrat

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun DialogSaved(index: Int, bookmark: Bookmark, bookmarksScreenViewModel: BookmarksScreenViewModel) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .background(color = Color(0xFFD292FE)),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BoxWithConstraints {
                Text(
                    text = bookmark.texto!!,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = Color(0xFF00002E),
                        fontSize = 14.sp,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight(400),
                    ),
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 5.dp)
                        .widthIn(max = 260.dp)
                )
            }
            IconButton(
                onClick = {
                    bookmarksScreenViewModel.onDeleteBookmark(bookmark)
                },
            )
            {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Apagar")
            }
        }
    }
}