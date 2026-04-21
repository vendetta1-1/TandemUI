package com.uikit.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class TandemUiBorderWidth(
    val thin: Dp = 1.dp,
    val normal: Dp = 2.dp,
    val thick: Dp = 3.dp
)