package br.com.suell.bookfinder.data.repository

import br.com.suell.bookfinder.data.local.BookDao
import br.com.suell.bookfinder.data.local.BookEntity
import br.com.suell.bookfinder.data.remote.OpenLibraryApi
import br.com.suell.bookfinder.domain.model.Book
import br.com.suell.bookfinder.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookRepositoryImpl(
    private val api: OpenLibraryApi,
    private val dao: BookDao
) : BookRepository {

    override fun searchBooks(query: String): Flow<List<Book>> {
        return dao.searchBooks(query).map { books ->
            books.map { it.toDomain() }
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return dao.getFavoriteBooks().map { books ->
            books.map { it.toDomain() }
        }
    }

    override suspend fun setFavorite(book: Book, isFavorite: Boolean) {
        dao.updateFavorite(book.id, isFavorite)
    }

    override suspend fun refreshBooks(query: String) {
        val favoriteIds = dao.getFavoriteIds().toSet()

        val response = api.searchBooks(query)

        val books = response.books.map { item ->
            BookEntity(
                id = item.id,
                title = item.title,
                author = item.authors?.firstOrNull() ?: "Autor desconhecido",
                coverUrl = item.coverId?.let {
                    "https://covers.openlibrary.org/b/id/$it-M.jpg"
                },
                firstPublishYear = item.firstPublishYear,
                isFavorite = item.id in favoriteIds
            )
        }

        dao.insertBooks(books)
    }

    private fun BookEntity.toDomain() = Book(
        id = id,
        title = title,
        author = author,
        coverUrl = coverUrl,
        firstPublishYear = firstPublishYear,
        isFavorite = isFavorite
    )
}