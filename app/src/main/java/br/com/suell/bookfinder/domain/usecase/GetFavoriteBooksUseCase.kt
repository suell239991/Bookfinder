package br.com.suell.bookfinder.domain.usecase

import br.com.suell.bookfinder.domain.repository.BookRepository

class GetFavoriteBooksUseCase(
    private val repository: BookRepository
) {
    operator fun invoke() =
        repository.getFavoriteBooks()
}