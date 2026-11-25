package br.com.suell.bookfinder.domain.usecase

import br.com.suell.bookfinder.domain.repository.BookRepository

class RefreshBooksUseCase(
    private val repository: BookRepository
) {
    suspend operator fun invoke(query: String) {
        repository.refreshBooks(query)
    }
}