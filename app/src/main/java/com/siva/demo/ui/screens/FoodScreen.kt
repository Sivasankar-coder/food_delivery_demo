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
import com.siva.demo.data.repository.AppRepository
import com.siva.demo.ui.components.RestaurantCard
import com.siva.demo.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodScreen(repository: AppRepository) {
    val restaurants = remember { repository.getPopularFoodItems() }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(Constants.TITLE_FOOD, style = MaterialTheme.typography.titleLarge) },
            actions = {
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Default.FilterList, contentDescription = Constants.DESC_FILTER)
                }
            }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(restaurants) { restaurant ->
                RestaurantCard(
                    restaurant = restaurant
                )
            }
        }
    }
}
