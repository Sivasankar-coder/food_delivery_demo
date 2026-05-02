package com.siva.demo.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siva.demo.data.repository.AppRepository
import com.siva.demo.ui.components.PremiumBottomNavBar
import com.siva.demo.ui.navigation.Screen
import com.siva.demo.ui.screens.*


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val repository = remember { AppRepository() }

    Scaffold(
        bottomBar = { PremiumBottomNavBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(repository = repository)
            }
            composable(Screen.Food.route) {
                FoodScreen(repository = repository)
            }
            composable(Screen.Grocery.route) {
                GroceryScreen(repository = repository)
            }
            composable(Screen.Cart.route) {
                CartScreen(repository = repository)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(repository = repository)
            }
        }
    }
}
