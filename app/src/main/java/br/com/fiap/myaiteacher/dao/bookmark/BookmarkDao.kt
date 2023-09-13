package br.com.fiap.myaiteacher.dao.bookmark

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.myaiteacher.model.bookmark.Bookmark

@Dao()
interface BookmarkDao {

    // grava um novo bookmark feito
    @Insert
    fun salvar(bookmark: Bookmark): Long

    @Delete
    fun excluir(bookmark: Bookmark): Int

    @Query("SELECT * FROM t_ait_bookmark WHERE ds_bookmark = :nome")
    fun buscarBookmarkRealizado(nome: String): Bookmark?

    @Query("SELECT * FROM t_ait_bookmark")
    fun exibirBookmarks(): List<Bookmark>
}