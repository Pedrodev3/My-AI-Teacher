package br.com.fiap.myaiteacher.dao.login

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.myaiteacher.model.login.Login

@Dao
interface LoginDao {

    // grava um novo login feito
    @Insert
    fun salvar(login: Login): Long

    @Delete
    fun excluir(login: Login): Int

    @Query("SELECT * FROM t_ait_login WHERE nm_login = :nome")
    fun buscarLoginRealizado(nome: String): Login?

    @Query("SELECT * FROM t_ait_login WHERE rl_login = :isRealizado ORDER BY cd_login")
    fun exibirLoginsRealizados(isRealizado: Boolean): List<Login>

    @Query("SELECT * FROM t_ait_login WHERE rl_login = :isRealizado ORDER BY cd_login DESC LIMIT 1")
    fun exibirNome(isRealizado: Boolean): List<Login>
}