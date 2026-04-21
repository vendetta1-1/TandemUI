package com.uikit.foundation.providers

import androidx.compose.runtime.staticCompositionLocalOf
import com.uikit.tokens.TandemUiBorderWidth
import com.uikit.tokens.TandemUiColors
import com.uikit.tokens.TandemUiDuration
import com.uikit.tokens.TandemUiElevation
import com.uikit.tokens.TandemUiIconSize
import com.uikit.tokens.TandemUiRadius
import com.uikit.tokens.TandemUiSpacing

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
