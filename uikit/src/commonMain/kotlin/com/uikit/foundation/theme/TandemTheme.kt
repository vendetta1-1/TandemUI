package com.uikit.foundation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import com.uikit.foundation.providers.LocalUiBorderWidth
import com.uikit.foundation.providers.LocalUiBottomBarColors
import com.uikit.foundation.providers.LocalUiBottomBarSpacing
import com.uikit.foundation.providers.LocalUiCircularProgressBarColors
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
import com.uikit.tokens.progress.circular.TandemUiCircularProgressBarColors

/**
 * # TandemTheme
 *
 * Обертка цветовой темы
 *
 * @author Эльвин Надиров
 */
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

private fun defaultCircularProgressBarColors(colors: TandemUiColors): TandemUiCircularProgressBarColors {
    val highlight = lerp(colors.primary, Color.White, 0.45f)
    return TandemUiCircularProgressBarColors(
        trackColor = colors.surfaceVariant,
        gradientColors = listOf(
            colors.primary,
            colors.primary,
            highlight,
            colors.primary,
            colors.primary
        ),
        contentColor = colors.onSurface,
        glowColor = highlight,
        coreColor = colors.primary
    )
}

/**
 * # TandemTheme
 *
 * Обертка цветовой темы
 *
 * @param [darkTheme] темная или светлая тема на устройстве
 * @param [colors] цвета темы
 * @param [spacing] отступы
 * @param [radius] радиусы закругления
 * @param [elevation] возвышения
 * @param [duration] продолжительности в миллисекундах
 * @param [iconSize] размеры иконок
 * @param [borderWidth] толщина обводок
 * @param [bottomBarColors] цвета нижнего бара
 * @param [bottomBarSpacing] отступы нижнего бара
 * @param [content] контент оборачиваемый в тему
 *
 * @author Эльвин Надиров
 */
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
    circularProgressBarColors: TandemUiCircularProgressBarColors = defaultCircularProgressBarColors(colors),
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
        LocalUiBottomBarSpacing provides bottomBarSpacing,
        LocalUiCircularProgressBarColors provides circularProgressBarColors
    ) {
        content()
    }
}
