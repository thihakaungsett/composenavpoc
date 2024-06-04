package com.vladimir.features.bottomnav

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BottomNavScreenRoute(
    goToDetail: (String, String) -> Unit
) {
    val items = listOf(
        BusinessBottomNavigationItem.Timetable,
        BusinessBottomNavigationItem.Pricing,
        BusinessBottomNavigationItem.Bookings,
        BusinessBottomNavigationItem.Inbox
    )
    var currentSelectedIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            BottomNavigation {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = currentSelectedIndex == index,
                        onClick = { currentSelectedIndex = index },
                        icon = {
                            Icon(imageVector = item.selectedIcon, contentDescription = item.title)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues = paddingValues)) {
            when(currentSelectedIndex) {
                BusinessNavScreen.Timetable.index -> {
                    SampleScreen {
                        goToDetail("Timetable", "This is timetable screen")
                    }
                }
                BusinessNavScreen.Pricing.index -> {
                    SampleScreen {
                        goToDetail("Pricing", "This is pricing screen")
                    }
                }
                BusinessNavScreen.Booking.index -> {
                    SampleScreen {
                        goToDetail("Bookings", "This is booking screen")
                    }
                }
                BusinessNavScreen.Inbox.index -> {
                    SampleScreen {
                        goToDetail("Inbox", "This is inbox screen")
                    }
                }
            }
        }
    }
}

@Composable
fun SampleScreen(
    onClickDetail: () -> Unit
) {
    Scaffold {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            ElevatedButton(onClick = onClickDetail, modifier = Modifier.align(Alignment.Center)) {
                Text(text = "Go To Detail")
            }
        }
    }
}


private enum class BusinessNavScreen(val index: Int) {
    Timetable(0),
    Pricing(1),
    Booking(2),
    Inbox(3),
}
sealed class BusinessBottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
) {
    data object Timetable: BusinessBottomNavigationItem(
        title = "Timetable",
        selectedIcon = Icons.Default.DateRange,
    )
    data object Pricing: BusinessBottomNavigationItem(
        title = "Pricing",
        selectedIcon = Icons.Default.Star,
    )
    data object Inbox: BusinessBottomNavigationItem(
        title = "Inbox",
        selectedIcon = Icons.Default.MailOutline,
    )
    data object Bookings: BusinessBottomNavigationItem(
        title = "Bookings",
        selectedIcon = Icons.Default.Menu,
    )
}