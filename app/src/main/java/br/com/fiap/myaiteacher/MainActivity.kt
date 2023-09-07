package br.com.fiap.myaiteacher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.myaiteacher.ui.screen.chat.ChatScreen
import br.com.fiap.myaiteacher.ui.screen.LoginScreen
import br.com.fiap.myaiteacher.ui.screen.chat.ChatScreenViewModel
import br.com.fiap.myaiteacher.ui.theme.MyAITeacherTheme

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
                    NavHost(
                            navController = navController,
                            startDestination = "chat"
                    ) {
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
                        composable(route = "chat") {
                            ChatScreen(navController = navController, chatScreenViewModel = ChatScreenViewModel())
                        }
                    }
                }
            }
        }
    }
}

