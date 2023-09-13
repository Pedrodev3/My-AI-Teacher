package br.com.fiap.myaiteacher.ui.screen.chat.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.myaiteacher.ui.screen.chat.ChatScreenViewModel

@Composable
fun ColumnChat(
    configuration: Configuration,
    items: SnapshotStateList<String>,
    scrollState: LazyListState,
    chatScreenViewModel: ChatScreenViewModel
) {

    LazyColumn(
        modifier = Modifier
            .background(color = Color(0xFF2C2F34))
            .height((configuration.screenHeightDp * 0.758).dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(space = 56.dp, alignment = Alignment.Bottom),
        contentPadding = PaddingValues(vertical = 30.dp),
        state = scrollState
    ) {
        items.forEachIndexed { index, item ->
            item {
                DialogBaloon(
                    index = index,
                    text = item,
                    onTap = {
                        chatScreenViewModel.onChangeDialog()
                        chatScreenViewModel.onTapDialog(item)
                    }
                )
            }
        }
    }

    LaunchedEffect(items.size) {
            scrollState.animateScrollToItem(index = items.size)

    }
}