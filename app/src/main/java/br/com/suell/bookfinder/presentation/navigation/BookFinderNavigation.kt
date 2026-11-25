
package br.com.suell.bookfinder.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.suell.bookfinder.presentation.favorites.FavoritesScreen
import br.com.suell.bookfinder.presentation.favorites.FavoritesViewModel
import br.com.suell.bookfinder.presentation.home.HomeScreen
import br.com.suell.bookfinder.presentation.home.HomeViewModel

@Composable
fun BookFinderNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            val viewModel: HomeViewModel = hiltViewModel()

            HomeScreen(
                viewModel = viewModel,
                onFavoritesClick = {
                    navController.navigate("favorites")
                }
            )
        }

        composable("favorites") {
            val viewModel: FavoritesViewModel = hiltViewModel()

            FavoritesScreen(viewModel)
        }
    }
}
