package com.uikit.foundation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
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

object TandemTheme {
    val colors: TandemUiColors
        @Composable
        @ReadOnlyComposable
        get() = LocalUiColors.current

    val spacing: TandemUiSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalUiSpacing.current

    val radius: TandemUiRadius
        @Composable
        @ReadOnlyComposable
        get() = LocalUiRadius.current

    val elevation: TandemUiElevation
        @Composable
        @ReadOnlyComposable
        get() = LocalUiElevation.current

    val duration: TandemUiDuration
        @Composable
        @ReadOnlyComposable
        get() = LocalUiDuration.current

    val iconSize: TandemUiIconSize
        @Composable
        @ReadOnlyComposable
        get() = LocalUiIconSize.current

    val borderWidth: TandemUiBorderWidth
        @Composable
        @ReadOnlyComposable
        get() = LocalUiBorderWidth.current
}