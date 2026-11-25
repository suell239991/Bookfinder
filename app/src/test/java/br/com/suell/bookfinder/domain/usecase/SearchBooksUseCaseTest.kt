
package br.com.suell.bookfinder.domain.usecase

import br.com.suell.bookfinder.domain.model.Book
import br.com.suell.bookfinder.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class SearchBooksUseCaseTest {

    @Test
    fun `deve retornar os livros encontrados pelo repositorio`() = runBlocking {
        val book = Book(
            id = "1",
            title = "O Senhor dos Aneis",
            author = "J.R.R. Tolkien",
            coverUrl = null,
            firstPublishYear = 1954
        )

        val repository = object : BookRepository {
            override fun searchBooks(query: String): Flow<List<Book>> =
                flowOf(listOf(book))

            override fun getFavoriteBooks(): Flow<List<Book>> =
                flowOf(emptyList())

            override suspend fun setFavorite(book: Book, isFavorite: Boolean) {}

            override suspend fun refreshBooks(query: String) {}
        }

        val useCase = SearchBooksUseCase(repository)

        val result = useCase("Senhor dos Aneis").first()

        assertEquals(listOf(book), result)
    }
}
