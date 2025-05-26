package com.pdmlabos.parcial2.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.pdmlabos.parcial2.viewmodel.ProductViewModel

@Composable
fun ProductDetailScreen(viewModel: ProductViewModel, navController: NavController) {
    val product = viewModel.selectedProduct ?: return
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
        }

        Spacer(Modifier.height(8.dp))

        Image(
            painter = rememberAsyncImagePainter(product.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = product.name,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = product.category,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Text(
            text = "$${product.price}",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF4CAF50)
        )

        Spacer(Modifier.height(12.dp))

        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.addToCart(product)
                Toast.makeText(
                    context,
                    "Producto añadido correctamente al carrito",
                    Toast.LENGTH_SHORT
                ).show()
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text("Agregar al carrito", color = Color.White)
        }
    }
}