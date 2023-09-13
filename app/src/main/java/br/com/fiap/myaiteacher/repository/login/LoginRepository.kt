package br.com.fiap.myaiteacher.repository.login

import android.content.Context
import br.com.fiap.myaiteacher.dao.login.LoginDb
import br.com.fiap.myaiteacher.model.login.Login

class LoginRepository(context: Context) {

    private val db = LoginDb.getBanco(context).loginDao()

    fun salvar(login: Login): Long {
        return db.salvar(login = login)
    }

    fun excluir(login: Login): Int {
        return db.excluir(login = login)
    }

    fun buscarLoginRealizado(nome: String): Login? {
        return db.buscarLoginRealizado(nome = nome)
    }

    fun exibirLoginsRealizados(isRealizado: Boolean): List<Login> {
        return db.exibirLoginsRealizados(isRealizado)
    }
}