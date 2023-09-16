package br.com.fiap.myaiteacher.ui.screen.chat

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.myaiteacher.ui.screen.chat.components.ColumnChat
import br.com.fiap.myaiteacher.ui.screen.chat.components.FooterChat
import br.com.fiap.myaiteacher.ui.screen.chat.components.HeaderChat
import br.com.fiap.myaiteacher.ui.screen.login.LoginScreenViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun ChatScreen(navController: NavController, chatScreenViewModel: ChatScreenViewModel) {

    val nomeState = rememberNavController().currentBackStackEntry
        ?.arguments?.getString("nomeState") ?: ""

    val configuration = LocalConfiguration.current
    val items by chatScreenViewModel.commentsList.observeAsState(initial = mutableStateListOf())
    val comment by chatScreenViewModel.comment.observeAsState(initial = "")
    val scrollState = rememberLazyListState()

    Column {
        HeaderChat(navController = navController, configuration = configuration, viewModel = LoginScreenViewModel())
        Spacer(modifier = Modifier.height((configuration.screenHeightDp * 0.002).dp))
        ColumnChat(configuration = configuration, items = items, scrollState = scrollState, chatScreenViewModel = chatScreenViewModel)
        Spacer(modifier = Modifier.height((configuration.screenHeightDp * 0.001).dp))
        FooterChat(configuration = configuration, comment = comment, chatScreenViewModel = chatScreenViewModel)
    }
}