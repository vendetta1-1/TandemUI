package com.uikit.release

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.uikit.component.bar.bottom.TandemUiBottomBar
import com.uikit.component.bar.bottom.TandemUiBottomBarDefaults
import com.uikit.component.bar.bottom.TandemUiBottomBarItem
import com.uikit.component.text.TandemUiText
import tandemui.release.generated.resources.Res
import tandemui.release.generated.resources.assignment
import tandemui.release.generated.resources.bar_chart
import tandemui.release.generated.resources.school
import tandemui.release.generated.resources.tab_learning
import tandemui.release.generated.resources.tab_statistics
import tandemui.release.generated.resources.tab_tasks

/**
 * # Release
 *
 * - Функия предназначена для демонстрации элементов ui-kit на платформах
 *
 * */

sealed class Tab {
    object Learning : Tab()

    object Tasks : Tab()

    object Statistics : Tab()
}

@Composable
fun Release() {
    var selectedRoute by remember { mutableStateOf<Tab>(Tab.Learning) }
    val items = remember {
        listOf(
            TandemUiBottomBarItem(
                titleStringResource = Res.string.tab_learning,
                iconDrawableResource = Res.drawable.school,
                route = Tab.Learning
            ),
            TandemUiBottomBarItem(
                titleStringResource = Res.string.tab_tasks,
                iconDrawableResource = Res.drawable.assignment,
                route = Tab.Tasks
            ),
            TandemUiBottomBarItem(
                titleStringResource = Res.string.tab_statistics,
                iconDrawableResource = Res.drawable.bar_chart,
                route = Tab.Statistics
            ),
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                when (selectedRoute) {
                    else -> LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(
                            items = List(100) { selectedRoute.toString() }
                        ) {
                            TandemUiText(
                                text = it,
                                color = Color.Black,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
            TandemUiBottomBar(
                items = items,
                selectedRoute = selectedRoute,
                onItemClick = { selectedRoute = it },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}