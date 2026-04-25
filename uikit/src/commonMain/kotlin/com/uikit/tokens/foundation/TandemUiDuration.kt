package com.uikit.tokens.foundation

import androidx.compose.runtime.Immutable

/**
 * # TandemUiDuration
 *
 * Константы продолжительности в миллисекундах
 *
 * @author Эльвин Надиров
 */
@Immutable
data class TandemUiDuration(
    val instant: Int = 0,
    val fast: Int = 200,
    val normal: Int = 300,
    val slow: Int = 450,
    val slower: Int = 600
)