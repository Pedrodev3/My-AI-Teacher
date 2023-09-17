package br.com.fiap.myaiteacher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.myaiteacher.repository.bookmark.BookmarkRepository
import br.com.fiap.myaiteacher.repository.login.LoginRepository
import br.com.fiap.myaiteacher.ui.screen.bookmarks.BookmarksScreen
import br.com.fiap.myaiteacher.ui.screen.bookmarks.BookmarksScreenViewModel
import br.com.fiap.myaiteacher.ui.screen.chat.ChatScreen
import br.com.fiap.myaiteacher.ui.screen.login.LoginScreen
import br.com.fiap.myaiteacher.ui.screen.chat.ChatScreenViewModel
import br.com.fiap.myaiteacher.ui.theme.MyAITeacherTheme
import br.com.fiap.myaiteacher.ui.screen.login.LoginScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAITeacherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = rememberNavController()
                    val scrollState = rememberLazyListState()
                    val context = LocalContext.current
                    val bookmarkRepository = BookmarkRepository(context = context)
                    val loginScreenViewModel = LoginScreenViewModel()
                    val loginRepository = LoginRepository(context = context)
                    val isLogged: Boolean = loginRepository.exibirLoginsRealizados(isRealizado = true).isNotEmpty()
                    NavHost(
                            navController = navController,
                            startDestination = if (isLogged) "chat" else "login"
                    ) {
                        composable(route = "login") {
                            LoginScreen(navController, loginScreenViewModel = loginScreenViewModel, scrollState = scrollState)
                        }
                        composable(route = "chat") {
                            ChatScreen(navController = navController, chatScreenViewModel = ChatScreenViewModel(), loginRepository = loginRepository)
                        }
                        composable(route = "bookmarks") {
                            BookmarksScreen(navController = navController, bookmarksScreenViewModel = BookmarksScreenViewModel(bookmarkRepository = bookmarkRepository))
                        }
                    }
                }
            }
        }
    }
}

