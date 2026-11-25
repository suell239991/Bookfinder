package br.com.suell.bookfinder.domain.repository

import br.com.suell.bookfinder.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    fun searchBooks(query: String): Flow<List<Book>>

    fun getFavoriteBooks(): Flow<List<Book>>

    suspend fun setFavorite(book: Book, isFavorite: Boolean)

    suspend fun refreshBooks(query: String)
}