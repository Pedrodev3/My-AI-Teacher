package br.com.fiap.myaiteacher.ui.screen.login

import android.annotation.SuppressLint
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.myaiteacher.model.Login
import br.com.fiap.myaiteacher.repository.LoginRepository

class LoginScreenViewModel : ViewModel() {

    private val _nomeState = MutableLiveData<String>()
    val nomeState: LiveData<String> = _nomeState
    fun onNomeChange(novoNome: String) {
        _nomeState.value = novoNome
    }

    private val _emailState = MutableLiveData<String>()
    val emailState: LiveData<String> = _emailState
    fun onEmailChange(novoEmail: String) {
        _emailState.value = novoEmail
    }

    private val _instituicaoState = MutableLiveData<String>()
    val instituicaoState: LiveData<String> = _instituicaoState
    fun onInstituicaoChange(novaInstituicao: String) {
        _instituicaoState.value = novaInstituicao
    }

    private val _dateState = MutableLiveData<String>()
    val dateState: LiveData<String> = _dateState
    fun onDateChange(novaData: String) {
        _dateState.value = novaData
    }

    private val _telefoneState = MutableLiveData<String>()
    val telefoneState: LiveData<String> = _telefoneState
    fun onTelefoneChange(novoTelefone: String) {
        _telefoneState.value = novoTelefone
    }

    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean> = _loginState

    fun createLogin(value: Boolean) {
        _loginState.value = value
    }

    fun showName() {
        return onNomeChange(_nomeState.value.toString())
    }
}
