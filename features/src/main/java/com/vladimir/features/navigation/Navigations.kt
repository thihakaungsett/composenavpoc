package com.vladimir.features.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

const val DETAIL_ROUTE = "detail_route"
const val BOTTOM_NAV_ROUTE = "bottom_nav_route"

fun NavController.navigateToDetail(navOptions: NavOptions) = navigate(DETAIL_ROUTE, navOptions)
fun NavController.navigateToBottomNav(navOptions: NavOptions) = navigate(BOTTOM_NAV_ROUTE, navOptions)

