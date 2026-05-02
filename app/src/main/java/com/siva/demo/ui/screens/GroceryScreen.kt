package com.siva.demo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.siva.demo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryScreen() {
    val categories = listOf(
        GroceryCategory("Vegetables", R.drawable.vegs, Color(0xFFE8F5E9)),
        GroceryCategory("Fruits", R.drawable.fruits, Color(0xFFFFF3E0)),
        GroceryCategory("Dairy & Eggs", R.drawable.eggs, Color(0xFFE3F2FD)),
        GroceryCategory("Bakery",R.drawable.bakery , Color(0xFFFBE9E7)),
        GroceryCategory("Snacks",R.drawable.snacks , Color(0xFFFFFDE7)),
        GroceryCategory("Beverages",R.drawable.beverages , Color(0xFFF3E5F5)),
        GroceryCategory("Meat", R.drawable.meat, Color(0xFFFFEBEE)),
        GroceryCategory("Cleaning", R.drawable.cleaning, Color(0xFFE0F7FA))
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Groceries", style = MaterialTheme.typography.titleLarge) }
        )
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(categories) { category ->
                GroceryCategoryCard(category)
            }
        }
    }
}

@Composable
fun GroceryCategoryCard(category: GroceryCategory) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = category.bgColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = category.image,
                contentDescription = category.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = category.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

data class GroceryCategory(val name: String, val image: Any, val bgColor: Color)
