package com.uikit.tokens.bar.bottom

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable

/**
 * # TandemUiBottomBarSpacing
 *
 * Класс, описывающий отступы нижнего бара
 *
 * @param [floatingPadding] отступы от краёв экрана до нижнего бара
 * @param [contentPadding] отступы от краёв бара до его контента
 *
 * @see com.uikit.component.bar.bottom.TandemUiBottomBar
 */
@Immutable
data class TandemUiBottomBarSpacing(
    val floatingPadding: PaddingValues,
    val contentPadding: PaddingValues
)
