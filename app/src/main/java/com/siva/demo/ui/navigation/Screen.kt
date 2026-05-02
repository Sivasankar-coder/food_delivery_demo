package com.siva.demo.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.siva.demo.utils.Constants

sealed class Screen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Home : Screen(
        route = Constants.ROUTE_HOME,
        title = Constants.NAV_HOME,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )
    object Food : Screen(
        route = Constants.ROUTE_FOOD,
        title = Constants.NAV_FOOD,
        selectedIcon = Icons.Filled.Restaurant,
        unselectedIcon = Icons.Outlined.Restaurant
    )
    object Grocery : Screen(
        route = Constants.ROUTE_GROCERY,
        title = Constants.NAV_GROCERY,
        selectedIcon = Icons.Filled.ShoppingBag,
        unselectedIcon = Icons.Outlined.ShoppingBag
    )
    object Cart : Screen(
        route = Constants.ROUTE_CART,
        title = Constants.NAV_CART,
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart
    )
    object Profile : Screen(
        route = Constants.ROUTE_PROFILE,
        title = Constants.NAV_PROFILE,
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
