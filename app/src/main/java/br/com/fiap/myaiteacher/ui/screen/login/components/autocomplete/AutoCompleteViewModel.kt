package br.com.fiap.myaiteacher.ui.screen.login.components.autocomplete

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AutoCompleteViewModel: ViewModel() {
    private val _categoryState = MutableLiveData("")
    val categoryState: LiveData<String> = _categoryState

    fun updateCategory(newCategory: String) {
        _categoryState.value = newCategory
    }
}