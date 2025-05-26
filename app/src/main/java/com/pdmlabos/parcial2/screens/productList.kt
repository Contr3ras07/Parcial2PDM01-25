package com.pdmlabos.parcial2.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.pdmlabos.parcial2.viewmodel.ProductViewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel, navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            BasicTextField(
                value = viewModel.searchQuery,
                onValueChange = { viewModel.onSearch(it) },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .background(Color.White, shape = MaterialTheme.shapes.small)
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                decorationBox = { innerTextField ->
                    if (viewModel.searchQuery.isEmpty()) {
                        Text("Buscar por nombre o categoría", color = Color.Gray)
                    }
                    innerTextField()
                }
            )
            IconButton(onClick = { navController.navigate("cart") }) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito")
            }
        }

        Spacer(Modifier.height(8.dp))

        LazyColumn {
            items(viewModel.getFilteredProducts().size) { index ->
                val product = viewModel.getFilteredProducts()[index]

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                viewModel.selectProduct(product)
                                navController.navigate("product_detail")
                            }
                            .padding(12.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(product.image),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = product.name, style = MaterialTheme.typography.titleMedium)
                            Text(text = product.category, color = Color.Gray)
                            Text(text = "$${product.price}", color = Color(0xFF4CAF50))
                            Spacer(Modifier.height(8.dp))
                            Button(
                                onClick = {
                                    viewModel.addToCart(product)
                                    Toast.makeText(
                                        context,
                                        "Producto añadido correctamente al carrito",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                            ) {
                                Text("Agregar al carrito", color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}