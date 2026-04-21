package com.uikit.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class TandemUiColors(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,

    val secondary: Color,
    val onSecondary: Color,

    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,
    val surfaceDim: Color,

    val outline: Color,
    val outlineVariant: Color,

    val error: Color,
    val onError: Color,
    val success: Color,
    val onSuccess: Color,
    val warning: Color,
    val onWarning: Color,

    val scrim: Color,
    val disabled: Color,
    val onDisabled: Color
)

fun lightUiColors(): TandemUiColors = TandemUiColors(
    primary = ColorPalette.blue600,
    onPrimary = ColorPalette.neutral0,
    primaryContainer = ColorPalette.blue50,
    onPrimaryContainer = ColorPalette.blue800,
    secondary = ColorPalette.neutral700,
    onSecondary = ColorPalette.neutral0,
    background = ColorPalette.neutral0,
    onBackground = ColorPalette.neutral900,
    surface = ColorPalette.neutral0,
    onSurface = ColorPalette.neutral900,
    surfaceVariant = ColorPalette.neutral100,
    onSurfaceVariant = ColorPalette.neutral600,
    surfaceDim = ColorPalette.neutral50,
    outline = ColorPalette.neutral300,
    outlineVariant = ColorPalette.neutral200,
    error = ColorPalette.red500,
    onError = ColorPalette.neutral0,
    success = ColorPalette.green500,
    onSuccess = ColorPalette.neutral0,
    warning = ColorPalette.orange500,
    onWarning = ColorPalette.neutral0,
    scrim = ColorPalette.neutral1000,
    disabled = ColorPalette.neutral200,
    onDisabled = ColorPalette.neutral400
)

fun darkUiColors(): TandemUiColors = TandemUiColors(
    primary = ColorPalette.blue600,
    onPrimary = ColorPalette.neutral0,
    primaryContainer = ColorPalette.blue50,
    onPrimaryContainer = ColorPalette.blue800,
    secondary = ColorPalette.neutral700,
    onSecondary = ColorPalette.neutral0,
    background = ColorPalette.neutral0,
    onBackground = ColorPalette.neutral900,
    surface = ColorPalette.neutral0,
    onSurface = ColorPalette.neutral900,
    surfaceVariant = ColorPalette.neutral100,
    onSurfaceVariant = ColorPalette.neutral600,
    surfaceDim = ColorPalette.neutral50,
    outline = ColorPalette.neutral300,
    outlineVariant = ColorPalette.neutral200,
    error = ColorPalette.red500,
    onError = ColorPalette.neutral0,
    success = ColorPalette.green500,
    onSuccess = ColorPalette.neutral0,
    warning = ColorPalette.orange500,
    onWarning = ColorPalette.neutral0,
    scrim = ColorPalette.neutral1000,
    disabled = ColorPalette.neutral200,
    onDisabled = ColorPalette.neutral400
)