package com.siva.demo.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Home : Screen(
        route = "home",
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )
    object Food : Screen(
        route = "food",
        title = "Food",
        selectedIcon = Icons.Filled.Restaurant,
        unselectedIcon = Icons.Outlined.Restaurant
    )
    object Grocery : Screen(
        route = "grocery",
        title = "Grocery",
        selectedIcon = Icons.Filled.ShoppingBag,
        unselectedIcon = Icons.Outlined.ShoppingBag
    )
    object Cart : Screen(
        route = "cart",
        title = "Cart",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart
    )
    object Profile : Screen(
        route = "profile",
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person
    )
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.Food,
    Screen.Grocery,
    Screen.Cart,
    Screen.Profile
)
