package br.com.fiap.myaiteacher.ui.screen.bookmarks

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.myaiteacher.model.bookmark.Bookmark
import br.com.fiap.myaiteacher.repository.bookmark.BookmarkRepository

class BookmarksScreenViewModel(bookmarkRepository: BookmarkRepository): ViewModel() {

    private val _bookmarkRepository = bookmarkRepository

    private val _bookmarksList = MutableLiveData(bookmarkRepository.exibirBoomarks())
    val bookmarksList: LiveData<List<Bookmark>> = _bookmarksList

    private val _selected = MutableLiveData<Int>()
    val selected: LiveData<Int> = _selected


    fun onChangeSelected(newSelected: Int) {
        _selected.value = newSelected
    }

    fun onDeleteBookmark(bookmark: Bookmark) {
        val currentList = _bookmarksList.value?.toMutableList() ?: mutableListOf()
        currentList.removeIf { it.codigo == bookmark.codigo }
        _bookmarkRepository.excluir(bookmark = bookmark)
        _bookmarksList.value = currentList
    }
}