package com.siva.demo.data.repository

import androidx.compose.ui.graphics.Color
import com.siva.demo.R
import com.siva.demo.data.model.*
import com.siva.demo.utils.Constants

class AppRepository {

    fun getFeaturedRestaurants(): List<Restaurant> {
        return listOf(
            Restaurant(Constants.RESTAURANT_GOURMET_KITCHEN, R.drawable.hotel1, 4.8, Constants.DELIVERY_25_30, Constants.CUISINE_ITALIAN),
            Restaurant(Constants.RESTAURANT_URBAN_BURGER, R.drawable.hotel2, 4.5, Constants.DELIVERY_15_20, Constants.CUISINE_AMERICAN),
            Restaurant(Constants.RESTAURANT_SUSHI_ZEN, R.drawable.hotel3, 4.9, Constants.DELIVERY_35_40, Constants.CUISINE_JAPANESE),
            Restaurant(Constants.RESTAURANT_GREEN_LEAF, R.drawable.hotel4, 4.2, Constants.DELIVERY_20_25, Constants.CUISINE_SALADS),
            Restaurant(Constants.RESTAURANT_SWEET_DREAMS, R.drawable.hotel5, 4.7, Constants.DELIVERY_30_35, Constants.CUISINE_BAKERY)
        )
    }

    fun getPopularFoodItems(): List<Restaurant> {
        return listOf(
            Restaurant(Constants.RESTAURANT_PIZZA_PARADISO, R.drawable.pizza, 4.6, Constants.DELIVERY_30_35, Constants.CUISINE_PIZZA),
            Restaurant(Constants.RESTAURANT_BURGER_KING, R.drawable.burger, 4.3, Constants.DELIVERY_20_25, Constants.CUISINE_BURGERS),
            Restaurant(Constants.RESTAURANT_WOK_ON_WHEELS, R.drawable.noodles, 4.5, Constants.DELIVERY_25_30, Constants.CUISINE_CHINESE),
            Restaurant(Constants.RESTAURANT_TACO_BELL, R.drawable.bell, 4.1, Constants.DELIVERY_15_20, Constants.CUISINE_MEXICAN)
        )
    }

    fun getGroceryCategories(): List<GroceryCategory> {
        return listOf(
            GroceryCategory(Constants.CATEGORY_VEGETABLES, R.drawable.vegs, Color(0xFFE8F5E9)),
            GroceryCategory(Constants.CATEGORY_FRUITS, R.drawable.fruits, Color(0xFFFFF3E0)),
            GroceryCategory(Constants.CATEGORY_DAIRY_EGGS, R.drawable.eggs, Color(0xFFE3F2FD)),
            GroceryCategory(Constants.CATEGORY_BAKERY, R.drawable.bakery, Color(0xFFFBE9E7)),
            GroceryCategory(Constants.CATEGORY_SNACKS, R.drawable.snacks, Color(0xFFFFFDE7)),
            GroceryCategory(Constants.CATEGORY_BEVERAGES, R.drawable.beverages, Color(0xFFF3E5F5)),
            GroceryCategory(Constants.CATEGORY_MEAT, R.drawable.meat, Color(0xFFFFEBEE)),
            GroceryCategory(Constants.CATEGORY_CLEANING, R.drawable.cleaning, Color(0xFFE0F7FA))
        )
    }

    fun getUserProfile(): UserProfile {
        return UserProfile(
            name = Constants.USER_NAME,
            email = Constants.USER_EMAIL,
            profilePicture = R.drawable.user
        )
    }

    fun getCartItems(): List<CartItem> {
        // Returning empty list by default as per original CartScreen state
        return emptyList()
    }
}
