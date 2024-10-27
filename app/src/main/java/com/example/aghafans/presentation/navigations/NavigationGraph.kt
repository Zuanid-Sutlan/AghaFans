package com.example.aghafans.presentation.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aghafans.presentation.model.Screen
import com.example.aghafans.presentation.screens.HomeScreen
import com.example.aghafans.presentation.screens.ShopScreen
import com.example.aghafans.presentation.screens.SplashScreen
import com.example.aghafans.presentation.screens.setting.SettingScreen
import com.example.aghafans.utils.Constants
import kotlinx.serialization.Serializable

@Composable
fun SetUpNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    NavHost(modifier = modifier, navController = navController, startDestination = Screens.HomeScreen) {
        composable<Screens.HomeScreen> {
            HomeScreen(url = Constants.HOME_URL)
        }
        composable<Screens.ShopScreen> {
            ShopScreen()
        }
        composable<Screens.SettingScreen> {
            SettingScreen()
        }
        composable<Screens.SplashScreen> {
            SplashScreen()
        }
    }

}