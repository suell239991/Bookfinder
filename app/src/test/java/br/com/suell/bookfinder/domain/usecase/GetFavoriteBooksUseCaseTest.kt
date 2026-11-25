
package br.com.suell.bookfinder.domain.usecase

import br.com.suell.bookfinder.domain.model.Book
import br.com.suell.bookfinder.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetFavoriteBooksUseCaseTest {

    @Test
    fun `deve retornar os livros favoritos do repositorio`() = runBlocking {
        val favorite = Book(
            id = "1",
            title = "Harry Potter",
            author = "J.K. Rowling",
            coverUrl = null,
            firstPublishYear = 1997,
            isFavorite = true
        )

        val repository = object : BookRepository {
            override fun searchBooks(query: String): Flow<List<Book>> =
                flowOf(emptyList())

            override fun getFavoriteBooks(): Flow<List<Book>> =
                flowOf(listOf(favorite))

            override suspend fun setFavorite(book: Book, isFavorite: Boolean) {}

            override suspend fun refreshBooks(query: String) {}
        }

        val useCase = GetFavoriteBooksUseCase(repository)

        val result = useCase().first()

        assertEquals(listOf(favorite), result)
    }
}
