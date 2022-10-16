package com.example.bufi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bufi.screens.DetailPage
import com.example.bufi.screens.IntroScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationItem.splash.route){
        composable(NavigationItem.splash.route){
            IntroScreen(navController)
        }
        composable(NavigationItem.Home.route){
            Homepage(navController)
        }
        composable(NavigationItem.DetailPage.route){
            DetailPage(navController)
        }

    }
    
}




