package br.com.fiap.myaiteacher.repository.bookmark

import android.content.Context
import br.com.fiap.myaiteacher.dao.bookmark.BookmarkDb
import br.com.fiap.myaiteacher.dao.login.LoginDb
import br.com.fiap.myaiteacher.model.bookmark.Bookmark
import br.com.fiap.myaiteacher.model.login.Login

class BookmarkRepository(context: Context) {

    private val db = BookmarkDb.getBanco(context).bookmarkDao()

    fun salvar(bookmark: Bookmark): Long {
        return db.salvar(bookmark = bookmark)
    }

    fun excluir(bookmark: Bookmark): Int {
        return db.excluir(bookmark = bookmark)
    }

    fun buscarBookmarkRealizado(nome: String): Bookmark? {
        return db.buscarBookmarkRealizado(nome = nome)
    }

    fun exibirBoomarks(): List<Bookmark> {
        return db.exibirBookmarks()
    }
}