package com.siva.demo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.siva.demo.R
import com.siva.demo.ui.components.RestaurantCard
import com.siva.demo.ui.components.SectionHeader
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var isLoading by remember { mutableStateOf(true) }
    
    // Simulate loading delay
    LaunchedEffect(Unit) {
        delay(2000)
        isLoading = false
    }

    val restaurants = listOf(
        Restaurant("The Gourmet Kitchen", R.drawable.hotel1, 4.8, "25-30 min", "Italian"),
        Restaurant("Urban Burger", R.drawable.hotel2, 4.5, "15-20 min", "American"),
        Restaurant("Sushi Zen", R.drawable.hotel3, 4.9, "35-40 min", "Japanese"),
        Restaurant("Green Leaf", R.drawable.hotel4, 4.2, "20-25 min", "Salads"),
        Restaurant("Sweet Dreams", R.drawable.hotel5, 4.7, "30-35 min", "Bakery")
    )

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Demo", style = MaterialTheme.typography.titleLarge) },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Trending Section
            item {
                SectionHeader(title = "Trending Now", onSeeAllClick = {})
            }

            if (isLoading) {
                items(3) {
                    RestaurantCard(
                        title = "",
                        image = "",
                        rating = 0.0,
                        deliveryTime = "",
                        cuisine = "",
                        isLoading = true
                    )
                }
            } else {
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

            // Popular Section
            item {
                SectionHeader(title = "Popular Near You", onSeeAllClick = {})
            }

            items(restaurants.shuffled()) { restaurant ->
                RestaurantCard(
                    title = restaurant.name,
                    image = restaurant.image,
                    rating = restaurant.rating,
                    deliveryTime = restaurant.deliveryTime,
                    cuisine = restaurant.cuisine
                )
            }
            
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

data class Restaurant(
    val name: String,
    val image: Any,
    val rating: Double,
    val deliveryTime: String,
    val cuisine: String
)
