package br.com.suell.bookfinder.domain.usecase

import br.com.suell.bookfinder.domain.repository.BookRepository
import javax.inject.Inject

class RefreshBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {
    suspend operator fun invoke(query: String) {
        repository.refreshBooks(query)
    }
}