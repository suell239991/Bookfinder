package br.com.suell.bookfinder.presentation.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.suell.bookfinder.domain.model.Book
import br.com.suell.bookfinder.domain.usecase.GetFavoriteBooksUseCase
import br.com.suell.bookfinder.domain.usecase.SetFavoriteBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteBooksUseCase: GetFavoriteBooksUseCase,
    private val setFavoriteBookUseCase: SetFavoriteBookUseCase
) : ViewModel() {

    val favoriteBooks: StateFlow<List<Book>> =
        getFavoriteBooksUseCase()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun removeFavorite(book: Book) {
        viewModelScope.launch {
            setFavoriteBookUseCase(book, false)
        }
    }
}