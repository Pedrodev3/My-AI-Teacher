package br.com.fiap.myaiteacher.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.myaiteacher.model.Login

@Database(entities = [Login::class], version = 1)
abstract class LoginDb: RoomDatabase() {
    abstract fun loginDao(): LoginDao

    companion object {
        private lateinit var instancia: LoginDb

        fun getBanco(context: Context): LoginDb {

            if(!::instancia.isInitialized) {
                instancia = Room
                    .databaseBuilder(
                        context,
                        LoginDb::class.java,
                        "login_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instancia
        }
    }
}