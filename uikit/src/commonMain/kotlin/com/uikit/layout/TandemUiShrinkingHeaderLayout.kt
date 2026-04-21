package com.uikit.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.zIndex

/**
 * # TandemUiShrinkingHeaderLayout
 *
 * Макет с верхним заголовком, который уменьшается при прокрутке.
 *
 * @param [header] всегда видим и меняет размер в зависимости от прокрутки.
 * @param [content] основная прокручиваемая область, которая становится доступной после уменьшения заголовка.
 */
@Composable
fun TandemUiShrinkingHeaderLayout(
    header: @Composable (shrinked: Boolean) -> Unit,
    content: @Composable (lazyListState: LazyListState, headerHeightPx: Int) -> Unit,
    modifier: Modifier
) {
    val lazyListState = rememberLazyListState()
    val shrinked by remember(lazyListState) {
        derivedStateOf { lazyListState.isScrolled() }
    }
    var headerHeightPx by remember { mutableIntStateOf(0) }

    Box(modifier) {
        Column(
            Modifier
                .zIndex(1f)
                .onGloballyPositioned { coordinates ->
                    headerHeightPx = coordinates.size.height
                }
        ) {
            header(shrinked)
        }

        content(lazyListState, headerHeightPx)
    }
}

private fun LazyListState.isScrolled(): Boolean {
    return firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0
}