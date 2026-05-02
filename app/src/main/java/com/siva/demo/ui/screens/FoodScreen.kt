package com.siva.demo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siva.demo.R
import com.siva.demo.ui.components.RestaurantCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodScreen() {
    val restaurants = listOf(
        Restaurant("Pizza Paradiso", R.drawable.pizza, 4.6, "30-35 min", "Pizza"),
        Restaurant("Burger King", R.drawable.burger, 4.3, "20-25 min", "Burgers"),
        Restaurant("Wok on Wheels", R.drawable.noodles, 4.5, "25-30 min", "Chinese"),
        Restaurant("Taco Bell", R.drawable.bell, 4.1, "15-20 min", "Mexican")
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Explore Food", style = MaterialTheme.typography.titleLarge) },
            actions = {
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Default.FilterList, contentDescription = "Filter")
                }
            }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(restaurants) { restaurant ->
                RestaurantCard(
                    title = restaurant.name,
                    image = restaurant.image,
                    rating = restaurant.rating,
                    deliveryTime = restaurant.deliveryTime,
                    cuisine = restaurant.cuisine
                )
            }
        }
    }
}
