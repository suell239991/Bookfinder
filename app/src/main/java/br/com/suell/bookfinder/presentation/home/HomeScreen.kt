
package br.com.suell.bookfinder.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onFavoritesClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    var query by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "BookFinder",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = onFavoritesClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Meus favoritos")
        }

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Pesquisar livros") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Button(
            onClick = { viewModel.searchBooks(query) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pesquisar")
        }

        if (uiState.isLoading) {
            CircularProgressIndicator()
        }

        uiState.error?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error
            )
        }

        if (!uiState.isLoading && uiState.books.isEmpty() && uiState.error == null) {
            Text("Pesquise um livro para começar.")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(uiState.books) { book ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = book.title,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(text = "Autor: ${book.author}")

                        Text(
                            text = "Ano: ${book.firstPublishYear ?: "Não informado"}"
                        )

                        Button(
                            onClick = { viewModel.toggleFavorite(book) }
                        ) {
                            Text(
                                if (book.isFavorite) {
                                    "Remover dos favoritos"
                                } else {
                                    "Adicionar aos favoritos"
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
