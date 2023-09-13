package br.com.fiap.myaiteacher.dao.bookmark

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.myaiteacher.model.bookmark.Bookmark

@Database(
    entities = [Bookmark::class],
    version = 1
)
//@TypeConverters(Converters::class)
abstract class BookmarkDb: RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao

    companion object {
        private lateinit var instancia: BookmarkDb

        fun getBanco(context: Context): BookmarkDb {

            if(!Companion::instancia.isInitialized) {
                instancia = Room
                    .databaseBuilder(
                        context,
                        BookmarkDb::class.java,
                        "bookmark_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instancia
        }
    }
}