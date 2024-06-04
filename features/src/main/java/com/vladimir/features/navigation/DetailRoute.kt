package com.vladimir.features.navigation

import kotlinx.serialization.Serializable

@Serializable
data class DetailRoute(
    val title: String,
    val description: String
)