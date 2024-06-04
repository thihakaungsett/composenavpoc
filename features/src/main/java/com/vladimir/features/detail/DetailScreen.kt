package com.vladimir.features.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenRoute(title: String, description: String) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = title) })
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Text(text = description)
        }
    }
}
