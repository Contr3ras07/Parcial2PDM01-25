package com.pdmlabos.parcial2.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pdmlabos.parcial2.data.ProductRepository
import com.pdmlabos.parcial2.model.Product


class ProductViewModel : ViewModel() {

    private val _productList = mutableStateListOf<Product>().apply {
        addAll(ProductRepository.productList)
    }

    var searchQuery by mutableStateOf("")
        private set

    var selectedProduct by mutableStateOf<Product?>(null)
        private set

    val cartItems: List<Product>
        get() = _productList.filter { it.addedToCart }

    fun onSearch(query: String) {
        searchQuery = query
    }

    fun getFilteredProducts(): List<Product> {
        val query = searchQuery.lowercase()
        return if (query.isBlank()) _productList
        else _productList.filter {
            it.name.lowercase().contains(query) || it.category.lowercase().contains(query)
        }
    }

    fun selectProduct(product: Product) {
        selectedProduct = product
    }

    fun addToCart(product: Product) {
        val index = _productList.indexOfFirst { it.id == product.id }
        if (index != -1) {
            _productList[index] = _productList[index].copy(addedToCart = true)
        }
    }
    fun removeFromCart(product: Product) {
        val index = _productList.indexOfFirst { it.id == product.id }
        if (index != -1) {
            _productList[index] = _productList[index].copy(addedToCart = false)
        }
    }

}
