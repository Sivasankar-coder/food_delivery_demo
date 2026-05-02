package com.siva.demo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.siva.demo.data.model.ProfileOption
import com.siva.demo.data.model.UserProfile
import com.siva.demo.data.repository.AppRepository
import com.siva.demo.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(repository: AppRepository) {
    val userProfile = remember { repository.getUserProfile() }
    val options = remember {
        listOf(
            ProfileOption(Constants.OPTION_ORDERS, Icons.Outlined.ShoppingBag),
            ProfileOption(Constants.OPTION_FAVORITES, Icons.Outlined.FavoriteBorder),
            ProfileOption(Constants.OPTION_ADDRESSES, Icons.Outlined.LocationOn),
            ProfileOption(Constants.OPTION_PAYMENTS, Icons.Outlined.Payment),
            ProfileOption(Constants.OPTION_SETTINGS, Icons.Outlined.Settings),
            ProfileOption(Constants.OPTION_HELP, Icons.Outlined.HelpOutline),
            ProfileOption(Constants.OPTION_LOGOUT, Icons.Outlined.Logout)
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(Constants.TITLE_PROFILE, style = MaterialTheme.typography.titleLarge) }
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                ProfileHeader(userProfile)
            }
            items(options) { option ->
                ProfileOptionRow(option)
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    thickness = 0.5.dp,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.1f)
                )
            }
        }
    }
}

@Composable
fun ProfileHeader(userProfile: UserProfile) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = userProfile.profilePicture,
            contentDescription = Constants.TITLE_PROFILE,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = userProfile.name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(text = userProfile.email, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
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
