package br.com.suell.bookfinder.domain.usecase

import br.com.suell.bookfinder.domain.repository.BookRepository
import javax.inject.Inject

class SearchBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {
    operator fun invoke(query: String) = repository.searchBooks(query)
}