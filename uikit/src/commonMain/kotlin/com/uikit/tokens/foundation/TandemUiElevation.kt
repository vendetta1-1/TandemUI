package com.uikit.tokens.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * # TandemUiElevation
 *
 * Константы возвышений
 *
 * @author Эльвин Надиров
 */
@Immutable
data class TandemUiElevation(
    val none: Dp = 0.dp,
    val cs: Dp = 1.dp,
    val sm: Dp = 2.dp,
    val md: Dp = 4.dp,
    val lg: Dp = 8.dp,
    val xl: Dp = 12.dp,
    val xxl: Dp = 16.dp,
    val xxxl: Dp = 24.dp
)