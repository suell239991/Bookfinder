package br.com.suell.bookfinder.domain.usecase

import br.com.suell.bookfinder.domain.model.Book
import br.com.suell.bookfinder.domain.repository.BookRepository

class SetFavoriteBookUseCase(
    private val repository: BookRepository
) {
    suspend operator fun invoke(book: Book, isFavorite: Boolean) {
        repository.setFavorite(book, isFavorite)
    }
}