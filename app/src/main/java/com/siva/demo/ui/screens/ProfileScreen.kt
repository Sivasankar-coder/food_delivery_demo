package com.siva.demo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.siva.demo.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val options = listOf(
        ProfileOption("Your Orders", Icons.Outlined.ShoppingBag),
        ProfileOption("Favorite Restaurants", Icons.Outlined.FavoriteBorder),
        ProfileOption("Saved Addresses", Icons.Outlined.LocationOn),
        ProfileOption("Payments", Icons.Outlined.Payment),
        ProfileOption("Settings", Icons.Outlined.Settings),
        ProfileOption("Help & Support", Icons.Outlined.HelpOutline),
        ProfileOption("Logout", Icons.Outlined.Logout)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Profile", style = MaterialTheme.typography.titleLarge) }
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                ProfileHeader()
            }
            items(options) { option ->
                ProfileOptionRow(option)
                Divider(modifier = Modifier.padding(horizontal = 16.dp), thickness = 0.5.dp, color = MaterialTheme.colorScheme.outline.copy(alpha = 0.1f))
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = R.drawable.user,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "Siva", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(text = "sivademo@gmail.com", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
        }
    }
}

@Composable
fun ProfileOptionRow(option: ProfileOption) {
    Surface(
        onClick = { /* TODO */ },
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = option.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = option.title, style = MaterialTheme.typography.bodyLarge)
            }
            Icon(
                imageVector = Icons.Outlined.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
            )
        }
    }
}

data class ProfileOption(val title: String, val icon: ImageVector)
