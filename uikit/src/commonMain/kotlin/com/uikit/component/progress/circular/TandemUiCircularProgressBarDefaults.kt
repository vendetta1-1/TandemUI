package com.uikit.component.progress.circular

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uikit.foundation.providers.LocalUiCircularProgressBarColors
import com.uikit.foundation.theme.TandemTheme
import com.uikit.tokens.foundation.TandemUiColors
import com.uikit.tokens.progress.circular.TandemUiCircularProgressBarColors

object TandemUiCircularProgressBarDefaults {
    internal val DefaultDiameter: Dp
        @Composable
        @ReadOnlyComposable
        get() = 18.dp

    internal val DefaultStrokeWidth: Dp
        @Composable
        @ReadOnlyComposable
        get() = 16.dp

    internal val DefaultRevealDurationMs: Int
        @Composable
        @ReadOnlyComposable
        get() = 3600

    internal val DefaultTrackColor: Color
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.colors.surfaceVariant

    internal val DefaultGradientColors: List<Color>
        @ReadOnlyComposable
        @Composable
        get() = listOf(
            TandemTheme.colors.primary,
            TandemTheme.colors.primaryContainer
        )

    internal val DefaultContentColor: Color
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.colors.onSurface

    internal val DefaultGlowColor: Color
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.colors.primary

    internal val DefaultCoreColor: Color
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.colors.surface

    @Composable
    fun circularProgressBarColors(
        trackColor: Color = DefaultTrackColor,
        gradientColors: List<Color> = DefaultGradientColors,
        contentColor: Color = DefaultContentColor,
        glowColor: Color = DefaultGlowColor,
        coreColor: Color = DefaultCoreColor
    ): TandemUiCircularProgressBarColors = TandemTheme.colors.circularProgressBarColors.copy(
        trackColor = trackColor,
        gradientColors = gradientColors,
        contentColor = contentColor,
        glowColor = glowColor,
        coreColor = coreColor
    )

    private val TandemUiColors.circularProgressBarColors: TandemUiCircularProgressBarColors
        @Composable
        @ReadOnlyComposable
        get() = LocalUiCircularProgressBarColors.current
}