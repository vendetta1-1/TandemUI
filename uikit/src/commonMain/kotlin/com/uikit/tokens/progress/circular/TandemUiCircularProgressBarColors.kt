package com.uikit.tokens.progress.circular

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class TandemUiCircularProgressBarColors(
    val trackColor: Color,
    val gradientColors: List<Color>,
    val contentColor: Color,
    val glowColor: Color,
    val coreColor: Color
)
