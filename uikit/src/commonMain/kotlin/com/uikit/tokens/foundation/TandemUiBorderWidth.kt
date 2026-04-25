package com.uikit.tokens.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * # TandemUiBorderWidth
 *
 * Константы для толщины обводок
 *
 * @author Эльвин Надиров
 */
@Immutable
data class TandemUiBorderWidth(
    val thin: Dp = 1.dp,
    val normal: Dp = 2.dp,
    val thick: Dp = 3.dp
)