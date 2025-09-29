package com.example.cardapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cardapp.ui.CardDetailScreen
import com.example.cardapp.ui.CardListScreen
import com.example.cardapp.viewmodel.CardViewModel

@Composable
fun AppNavigation(navController: NavHostController) {
    val viewModel: CardViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "card_list"
    ) {
        composable("card_list") {
            CardListScreen(
                onCardClick = { cardId ->
                    navController.navigate("card_detail/$cardId")
                },
                viewModel = viewModel
            )
        }

        composable("card_detail/{cardId}") { backStackEntry ->
            val cardId = backStackEntry.arguments?.getString("cardId")?.toIntOrNull() ?: 0
            CardDetailScreen(
                cardId = cardId,
                onBackClick = {
                    navController.popBackStack()
                },
                viewModel = viewModel
            )
        }
    }
}