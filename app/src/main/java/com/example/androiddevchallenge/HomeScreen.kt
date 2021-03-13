/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenLightPreview() {
    MyTheme {
        HomeScreenMake()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreenMake()
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {

    // Edit Color Status Bar
    val context = LocalContext.current
    val activity = (context as MainActivity)
    activity.window.statusBarColor = context.resources.getColor(R.color.background, context.theme)

    HomeScreenMake()
}

sealed class Screen(val route: String, val resource: ImageVector) {
    object NaviHome : Screen("Home", Icons.Filled.Home)
    object NaviFavorites : Screen("Favorites", Icons.Filled.FavoriteBorder)
    object NaviProfile : Screen("Profile", Icons.Filled.AccountCircle)
    object NaviCart : Screen("Cart", Icons.Filled.ShoppingCart)
}

@Composable
fun HomeScreenMake() {

    val items = listOf(
        Screen.NaviHome,
        Screen.NaviFavorites,
        Screen.NaviProfile,
        Screen.NaviCart,
        )

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.resource, screen.route) },
                        label = { Text(screen.route) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            // NOP
                        }
                    )
                }
            }
        }
    ) {

        NavHost(navController, startDestination = Screen.NaviHome.route) {
            composable(Screen.NaviHome.route) { HomeChildScreen(navController) }
            composable(Screen.NaviFavorites.route) { }
            composable(Screen.NaviProfile.route) { }
            composable(Screen.NaviCart.route) { }
        }
    }
}
