package com.pdmlabos.parcial2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pdmlabos.parcial2.screens.CartScreen
import com.pdmlabos.parcial2.screens.ProductDetailScreen
import com.pdmlabos.parcial2.screens.ProductListScreen
import com.pdmlabos.parcial2.viewmodel.ProductViewModel

@Composable
fun AppNavHost(navController: NavHostController, viewModel: ProductViewModel) {
    NavHost(navController = navController, startDestination = Screen.ProductListScreen.route) {
        composable(Screen.ProductListScreen.route) {
            ProductListScreen(viewModel = viewModel, navController = navController)
        }
        composable(Screen.ProductDetailScreen.route) {
            ProductDetailScreen(viewModel = viewModel, navController = navController)
        }
        composable(Screen.CartScreen.route) {
            CartScreen(viewModel = viewModel, navController = navController)
        }
    }
}
