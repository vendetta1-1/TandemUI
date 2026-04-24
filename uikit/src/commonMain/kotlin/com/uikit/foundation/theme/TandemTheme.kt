package com.uikit.foundation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.uikit.foundation.providers.LocalUiBorderWidth
import com.uikit.foundation.providers.LocalUiBottomBarColors
import com.uikit.foundation.providers.LocalUiBottomBarSpacing
import com.uikit.foundation.providers.LocalUiColors
import com.uikit.foundation.providers.LocalUiDuration
import com.uikit.foundation.providers.LocalUiElevation
import com.uikit.foundation.providers.LocalUiIconSize
import com.uikit.foundation.providers.LocalUiRadius
import com.uikit.foundation.providers.LocalUiSpacing
import com.uikit.tokens.bar.bottom.TandemUiBottomBarColors
import com.uikit.tokens.bar.bottom.TandemUiBottomBarSpacing
import com.uikit.tokens.foundation.TandemUiBorderWidth
import com.uikit.tokens.foundation.TandemUiColors
import com.uikit.tokens.foundation.TandemUiDuration
import com.uikit.tokens.foundation.TandemUiElevation
import com.uikit.tokens.foundation.TandemUiIconSize
import com.uikit.tokens.foundation.TandemUiRadius
import com.uikit.tokens.foundation.TandemUiSpacing
import com.uikit.tokens.foundation.darkUiColors
import com.uikit.tokens.foundation.lightUiColors

private val DefaultLightColors = lightUiColors()
private val DefaultDarkColors = darkUiColors()
private val DefaultSpacing = TandemUiSpacing()
private val DefaultRadius = TandemUiRadius()
private val DefaultElevation = TandemUiElevation()
private val DefaultDuration = TandemUiDuration()
private val DefaultIconSize = TandemUiIconSize()
private val DefaultBorderWidth = TandemUiBorderWidth()

private fun defaultBottomBarColors(colors: TandemUiColors): TandemUiBottomBarColors =
    TandemUiBottomBarColors(
        selectedContainerColor = colors.primaryContainer,
        unselectedContainerColor = colors.secondary,
        selectedContentColor = colors.onPrimaryContainer,
        unselectedContentColor = colors.onSecondary
    )

private fun defaultBottomBarSpacing(spacing: TandemUiSpacing): TandemUiBottomBarSpacing =
    TandemUiBottomBarSpacing(
        floatingPadding = PaddingValues(
            horizontal = spacing.lg,
            vertical = spacing.md
        ),
        contentPadding = PaddingValues(all = spacing.xs)
    )

@Composable
fun TandemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: TandemUiColors = if (darkTheme) DefaultDarkColors else DefaultLightColors,
    spacing: TandemUiSpacing = DefaultSpacing,
    radius: TandemUiRadius = DefaultRadius,
    elevation: TandemUiElevation = DefaultElevation,
    duration: TandemUiDuration = DefaultDuration,
    iconSize: TandemUiIconSize = DefaultIconSize,
    borderWidth: TandemUiBorderWidth = DefaultBorderWidth,
    bottomBarColors: TandemUiBottomBarColors = defaultBottomBarColors(colors),
    bottomBarSpacing: TandemUiBottomBarSpacing = defaultBottomBarSpacing(spacing),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalUiColors provides colors,
        LocalUiSpacing provides spacing,
        LocalUiRadius provides radius,
        LocalUiElevation provides elevation,
        LocalUiDuration provides duration,
        LocalUiIconSize provides iconSize,
        LocalUiBorderWidth provides borderWidth,
        LocalUiBottomBarColors provides bottomBarColors,
        LocalUiBottomBarSpacing provides bottomBarSpacing
    ) {
        content()
    }
}
