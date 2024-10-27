package com.example.aghafans.presentation.navigations

import android.os.Parcelable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.aghafans.presentation.model.Screen
import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable
    object SplashScreen

    @Serializable
    object HomeScreen

    @Serializable
    object ShopScreen

    @Serializable
    object SettingScreen

}

val listOfBottomScreens = listOf(
    Screen(
        text = "Home",
        icon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        route = Screens.HomeScreen
    ),
    Screen(
        text = "Shop",
        icon = Icons.Outlined.ShoppingCart,
        selectedIcon = Icons.Filled.ShoppingCart,
        route = Screens.HomeScreen
    ),
    Screen(
        text = "Settings",
        icon = Icons.Outlined.Settings,
        selectedIcon = Icons.Filled.Settings,
        route = Screens.HomeScreen
    )
)

