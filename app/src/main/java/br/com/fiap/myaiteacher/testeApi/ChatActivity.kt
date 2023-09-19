package br.com.fiap.myaiteacher.testeApi

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class ChatActivity : ComponentActivity() {

    private val viewModel: ChatViewModel by stateViewModel(
        state = { intent?.extras ?: Bundle() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatGptBotAppTheme {
                ChatScreen(
                    uiHandler = ChatScreenUiHandlers(
                        onSendMessage = viewModel::SendMessage,
                        onResendMessage = viewModel::resendMessage,
                    ),
                    conversation = viewModel.conversation,
                    isSendingMessage = viewModel.isSendingMessage
                )
            }
        }
    }
}
