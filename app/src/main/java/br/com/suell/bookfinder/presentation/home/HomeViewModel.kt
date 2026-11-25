package br.com.suell.bookfinder.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.suell.bookfinder.domain.model.Book
import br.com.suell.bookfinder.domain.usecase.RefreshBooksUseCase
import br.com.suell.bookfinder.domain.usecase.SearchBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

data class HomeUiState(
    val books: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchBooksUseCase: SearchBooksUseCase,
    private val refreshBooksUseCase: RefreshBooksUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun searchBooks(query: String) {
        if (query.isBlank()) return

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null
            )

            launch {
                try {
                    refreshBooksUseCase(query)
                } catch (e: Exception) {
                    _uiState.value = _uiState.value.copy(
                        error = "Não foi possível atualizar os livros."
                    )
                }
            }

            searchBooksUseCase(query)
                .catch {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = "Erro ao carregar os livros."
                    )
                }
                .collect { books ->
                    _uiState.value = HomeUiState(
                        books = books,
                        isLoading = false
                    )
                }
        }
    }
}