package br.com.suell.bookfinder.domain.model

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val coverUrl: String?,
    val firstPublishYear: Int?,
    val isFavorite: Boolean = false
)