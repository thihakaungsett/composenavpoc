package com.vladimir.refactornavpoc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vladimir.features.navigation.BottomNavRoute
import com.vladimir.features.navigation.bottomNavScreen
import com.vladimir.features.navigation.detailScreen
import com.vladimir.features.navigation.navigateToDetail

@Composable
fun PocNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavRoute
    ) {
        detailScreen()
        bottomNavScreen(
            goToDetail = { title, description ->
                navController.navigateToDetail(title, description)
            }
        )
    }
}
