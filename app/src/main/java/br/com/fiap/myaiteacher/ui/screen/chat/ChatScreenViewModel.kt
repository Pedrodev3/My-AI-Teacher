package br.com.fiap.myaiteacher.ui.screen.chat

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ChatScreenViewModel: ViewModel() {

    private val mocks = arrayOf("A fórmula para calcular a área de um triângulo é (base x altura) / 2.", "A Lei da Gravidade de Newton afirma que todos os corpos atraem uns aos outros com uma força proporcional às massas e inversamente proporcional ao quadrado da distância.", "A Revolução Industrial foi um marco histórico no século 18 que impulsionou a industrialização e transformou a produção de bens.", "O Rio Amazonas é o rio mais longo do mundo, com cerca de 6.400 km de extensão.", "Um substantivo é uma palavra que representa um objeto, lugar, sentimento ou ideia, como 'casa' ou 'felicidade'.")

    private val _commentsList = MutableLiveData(mutableStateListOf<String>())
    val commentsList = _commentsList

    private val _comment = MutableLiveData<String>()
    val comment: LiveData<String> = _comment

    private val _selected = MutableLiveData<Int>()
    val selected: LiveData<Int> = _selected

    private val _isDialogShown = MutableLiveData(false)
    val isDialogShown: LiveData<Boolean> = _isDialogShown

    private val _currMessage = MutableLiveData<String>()
    val currMessage: LiveData<String> = _currMessage

    fun onCommentChanged(newComment: String) {
        _comment.value = newComment
    }

    fun onAddNewComment(newComment: String) {
        _commentsList.value?.add(newComment)
        val randomIndex = Random.nextInt(0, mocks.size)
        val randomElement = mocks[randomIndex]
        _commentsList.value?.add(randomElement)
    }

    fun onChangeSelected(newSelected: Int) {
        _selected.value = newSelected
    }

    fun onChangeDialog(){
        _isDialogShown.value = !_isDialogShown.value!!
    }

    fun onTapDialog(newMessage: String){
        _currMessage.value = newMessage
    }
}