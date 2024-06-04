package com.vladimir.features.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.vladimir.features.bottomnav.BottomNavScreenRoute
import com.vladimir.features.detail.DetailScreenRoute
fun NavController.navigateToDetail(title: String, description: String) = navigate(DetailRoute(title, description))
fun NavController.navigateToBottomNav() = navigate(BottomNavRoute)
fun NavGraphBuilder.detailScreen() {
    composable<DetailRoute> { backStackEntry ->
        val detail: DetailRoute = backStackEntry.toRoute()
        DetailScreenRoute(
            detail.title, detail.description
        )
    }
}
fun NavGraphBuilder.bottomNavScreen(
    goToDetail: (title: String, description: String) -> Unit
) {
    composable<BottomNavRoute> {
        BottomNavScreenRoute(
            goToDetail = goToDetail
        )
    }
}