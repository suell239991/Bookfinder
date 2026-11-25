package br.com.suell.bookfinder.presentation.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoritesScreen(viewModel: FavoritesViewModel) {
    val favoriteBooks by viewModel.favoriteBooks.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Meus favoritos",
            style = MaterialTheme.typography.headlineMedium
        )

        if (favoriteBooks.isEmpty()) {
            Text("Você ainda não tem livros favoritos.")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(favoriteBooks) { book ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { viewModel.removeFavorite(book) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = book.title,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(text = "Autor: ${book.author}")
                        Text(
                            text = "Toque para remover dos favoritos",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}