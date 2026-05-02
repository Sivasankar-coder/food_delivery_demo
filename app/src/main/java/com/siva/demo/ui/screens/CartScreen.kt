package com.siva.demo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.siva.demo.ui.components.EmptyStateView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    val cartItems = remember { mutableStateListOf<CartItem>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Cart", style = MaterialTheme.typography.titleLarge) }
            )
        },
        bottomBar = {
            if (cartItems.isNotEmpty()) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shadowElevation = 8.dp,
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Proceed to Pay ($12.50)", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    ) { padding ->
        if (cartItems.isEmpty()) {
            EmptyStateView(
                icon = Icons.Outlined.ShoppingCart,
                title = "Your cart is feeling lonely",
                subtitle = "Explore our wide range of foods and groceries and add items to your cart."
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(cartItems) { item ->
                    CartItemRow(item)
                }
                
                item {
                    BillSummaryCard()
                }
            }
        }
    }
}

@Composable
fun CartItemRow(item: CartItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = item.name, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
            Text(text = "$${item.price}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { /* TODO */ }) {
                Text("-", style = MaterialTheme.typography.titleLarge)
            }
            Text(text = "1", modifier = Modifier.padding(horizontal = 8.dp))
            IconButton(onClick = { /* TODO */ }) {
                Text("+", style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}

@Composable
fun BillSummaryCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Bill Summary", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(12.dp))
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text("Item Total")
                Text("$10.00")
            }
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text("Delivery Fee")
                Text("$2.00")
            }
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text("Taxes")
                Text("$0.50")
            }
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text("To Pay", fontWeight = FontWeight.Bold)
                Text("$12.50", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

data class CartItem(val name: String, val price: Double)
