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
import com.siva.demo.data.repository.AppRepository
import com.siva.demo.ui.components.RestaurantCard
import com.siva.demo.ui.components.SectionHeader
import com.siva.demo.utils.Constants
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(repository: AppRepository) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var isLoading by remember { mutableStateOf(true) }
    
    val featuredRestaurants = remember { repository.getFeaturedRestaurants() }

    // Simulate loading delay
    LaunchedEffect(Unit) {
        delay(2000)
        isLoading = false
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(Constants.APP_NAME, style = MaterialTheme.typography.titleLarge) },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Search, contentDescription = Constants.DESC_SEARCH)
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = Constants.DESC_NOTIFICATIONS)
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
                SectionHeader(title = Constants.SECTION_TRENDING, onSeeAllClick = {})
            }

            if (isLoading) {
                items(3) {
                    RestaurantCard(
                        restaurant = null,
                        isLoading = true
                    )
                }
            } else {
                items(featuredRestaurants) { restaurant ->
                    RestaurantCard(
                        restaurant = restaurant
                    )
                }
            }

            // Popular Section
            item {
                SectionHeader(title = Constants.SECTION_POPULAR, onSeeAllClick = {})
            }

            items(featuredRestaurants.shuffled()) { restaurant ->
                RestaurantCard(
                    restaurant = restaurant
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
