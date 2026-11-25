package br.com.suell.bookfinder.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(

    @PrimaryKey
    val id: String,

    val title: String,
    val author: String,
    val coverUrl: String?,
    val firstPublishYear: Int?,
    val isFavorite: Boolean = false
)