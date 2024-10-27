package com.example.aghafans.presentation.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.aghafans.presentation.navigations.Screens

data class Screen(
    val text: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector,
    val route: Any
)
