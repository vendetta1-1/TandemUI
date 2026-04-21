package com.uikit.foundation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.uikit.foundation.providers.LocalUiBorderWidth
import com.uikit.foundation.providers.LocalUiColors
import com.uikit.foundation.providers.LocalUiDuration
import com.uikit.foundation.providers.LocalUiElevation
import com.uikit.foundation.providers.LocalUiIconSize
import com.uikit.foundation.providers.LocalUiRadius
import com.uikit.foundation.providers.LocalUiSpacing
import com.uikit.tokens.TandemUiBorderWidth
import com.uikit.tokens.TandemUiColors
import com.uikit.tokens.TandemUiDuration
import com.uikit.tokens.TandemUiElevation
import com.uikit.tokens.TandemUiIconSize
import com.uikit.tokens.TandemUiRadius
import com.uikit.tokens.TandemUiSpacing
import com.uikit.tokens.darkUiColors
import com.uikit.tokens.lightUiColors

private val DefaultLightColors = lightUiColors()
private val DefaultDarkColors = darkUiColors()
private val DefaultSpacing = TandemUiSpacing()
private val DefaultRadius = TandemUiRadius()
private val DefaultElevation = TandemUiElevation()
private val DefaultDuration = TandemUiDuration()
private val DefaultIconSize = TandemUiIconSize()
private val DefaultBorderWidth = TandemUiBorderWidth()

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
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalUiColors provides colors,
        LocalUiSpacing provides spacing,
        LocalUiRadius provides radius,
        LocalUiElevation provides elevation,
        LocalUiDuration provides duration,
        LocalUiIconSize provides iconSize,
        LocalUiBorderWidth provides borderWidth
    ) {
        content()
    }
}