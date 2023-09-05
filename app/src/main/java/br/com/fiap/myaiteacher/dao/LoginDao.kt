package br.com.fiap.myaiteacher.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.myaiteacher.model.Login

@Dao()
interface LoginDao {

    // grava um novo login feito
    @Insert
    fun salvar(login: Login): Long

    @Query("SELECT * FROM t_ait_login WHERE rl_login = :isRealizado ORDER BY mm_login ASC")
    fun exibirLoginsRealizados(isRealizado: Boolean): List<Login>
}