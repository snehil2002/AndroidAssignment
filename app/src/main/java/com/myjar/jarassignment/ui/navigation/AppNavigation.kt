package com.myjar.jarassignment.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.myjar.jarassignment.ui.screens.ItemDetailScreen
import com.myjar.jarassignment.ui.screens.ItemListScreen
import com.myjar.jarassignment.ui.vm.JarViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    viewModel: JarViewModel,
) {
    val navController = rememberNavController()


    NavHost(modifier = modifier, navController = navController, startDestination = AppScreens.ItemListScreen.name) {
        composable(route = AppScreens.ItemListScreen.name) {
            ItemListScreen(
                viewModel = viewModel,
                navController = navController)
        }
        composable(route = "${AppScreens.ItemDetailScreen.name}/{itemId}", arguments = listOf(
            navArgument(name = "itemId"){type= NavType.StringType}
        )) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            ItemDetailScreen(navController = navController,itemId = itemId)
        }
    }
}


