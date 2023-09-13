package br.com.fiap.myaiteacher.model.bookmark

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_ait_bookmark")
data class Bookmark(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "cd_bookmark")
    var codigo: Long = 0,

    @ColumnInfo(name = "ds_bookmark")
    var texto: String? = null,
)
