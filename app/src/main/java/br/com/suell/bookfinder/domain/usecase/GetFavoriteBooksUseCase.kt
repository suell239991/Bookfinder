package br.com.suell.bookfinder.domain.usecase

import br.com.suell.bookfinder.domain.repository.BookRepository
import javax.inject.Inject

class GetFavoriteBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {
    operator fun invoke() = repository.getFavoriteBooks()
}