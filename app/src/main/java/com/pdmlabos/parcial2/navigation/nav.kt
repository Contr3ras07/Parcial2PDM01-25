package com.pdmlabos.parcial2.navigation


sealed class Screen(val route: String) {
    object ProductListScreen : Screen("product_list")
    object ProductDetailScreen : Screen("product_detail")
    object CartScreen : Screen("cart")
}
