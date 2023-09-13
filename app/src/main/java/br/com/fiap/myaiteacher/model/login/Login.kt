package br.com.fiap.myaiteacher.model.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "t_ait_login")
data class Login(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "cd_login")
    var codigo: Long = 0,

    @ColumnInfo(name = "nm_login")
    var nome: String? = null,

    @ColumnInfo(name = "ds_email")
    var email: String? = null,

    @ColumnInfo(name = "nm_instituicao")
    var instituicao: String? = null,

    @ColumnInfo(name = "dt_nascimento")
    var dataNascimento: String? = null,

    @ColumnInfo(name = "ds_telefone")
    var telefone: String? = null,

    @ColumnInfo(name = "rl_login")
    var realizado: Boolean = false,
)
