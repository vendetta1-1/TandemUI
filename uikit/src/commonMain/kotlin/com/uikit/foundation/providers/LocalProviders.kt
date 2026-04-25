package com.uikit.foundation.providers

import androidx.compose.runtime.staticCompositionLocalOf
import com.uikit.tokens.foundation.TandemUiBorderWidth
import com.uikit.tokens.bar.bottom.TandemUiBottomBarColors
import com.uikit.tokens.bar.bottom.TandemUiBottomBarSpacing
import com.uikit.tokens.foundation.TandemUiColors
import com.uikit.tokens.foundation.TandemUiDuration
import com.uikit.tokens.foundation.TandemUiElevation
import com.uikit.tokens.foundation.TandemUiIconSize
import com.uikit.tokens.foundation.TandemUiRadius
import com.uikit.tokens.foundation.TandemUiSpacing
import com.uikit.tokens.progress.circular.TandemUiCircularProgressBarColors

/**
 *  # LocalProviders
 *
 *  Провайдеры констант(цвета, отступы, радиусы и т.д) для темы
 *
 *  @author Эльвин Надиров
 */
val LocalUiColors = staticCompositionLocalOf<TandemUiColors> {
    error("TandemUiColors was not initialized. Wrap your UI root in TandemTheme { ... }")
}

val LocalUiSpacing = staticCompositionLocalOf<TandemUiSpacing> {
    error("TandemUiSpacing was not initialized. Wrap your UI root in TandemTheme { ... }")
}

val LocalUiRadius = staticCompositionLocalOf<TandemUiRadius> {
    error("TandemUiRadius was not initialized. Wrap your UI root in TandemTheme { ... }")
}

val LocalUiElevation = staticCompositionLocalOf<TandemUiElevation> {
    error("TandemUiElevation was not initialized. Wrap your UI root in TandemTheme { ... }")
}

val LocalUiDuration = staticCompositionLocalOf<TandemUiDuration> {
    error("TandemUiDuration was not initialized. Wrap your UI root in TandemTheme { ... }")
}

val LocalUiIconSize = staticCompositionLocalOf<TandemUiIconSize> {
    error("TandemUiIconSize was not initialized. Wrap your UI root in TandemTheme { ... }")
}

val LocalUiBorderWidth = staticCompositionLocalOf<TandemUiBorderWidth> {
    error("TandemUiBorderWidth was not initialized. Wrap your UI root in TandemTheme { ... }")
}

val LocalUiBottomBarColors = staticCompositionLocalOf<TandemUiBottomBarColors> {
    error("TandemUiBottomBarColors was not initialized. Wrap your UI root in TandemTheme { ... }")
}

val LocalUiBottomBarSpacing = staticCompositionLocalOf<TandemUiBottomBarSpacing> {
    error("TandemUiBottomBarSpacing was not initialized. Wrap your UI root in TandemTheme { ... }")
}

val LocalUiCircularProgressBarColors = staticCompositionLocalOf<TandemUiCircularProgressBarColors> {
    error("TandemUiCircularProgressBarColors was not initialized. Wrap your UI root in TandemTheme { ... }")
}