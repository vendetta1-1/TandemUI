package com.uikit.component.bar.bottom

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uikit.foundation.providers.LocalUiBottomBarColors
import com.uikit.foundation.providers.LocalUiBottomBarSpacing
import com.uikit.foundation.theme.TandemTheme
import com.uikit.tokens.bar.bottom.TandemUiBottomBarColors
import com.uikit.tokens.bar.bottom.TandemUiBottomBarSpacing
import com.uikit.tokens.foundation.TandemUiColors
import com.uikit.tokens.foundation.TandemUiSpacing

/**
 * # TandemUiBottomBarDefaults
 *
 * Значения по умолчанию для цветов, отступов, возвышения нижнего бара, а также функции для их переопределения
 */
object TandemUiBottomBarDefaults {

    val ContainerElevation: Dp
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.elevation.xxxl
    private val DefaultContentSpacing: Dp
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.spacing.xs
    private val DefaultHorizontalFloatingSpacing: Dp
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.spacing.lg
    private val DefaultVerticalFloatingSpacing: Dp
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.spacing.md

    internal val DefaultShape: Shape
        @Composable
        @ReadOnlyComposable
        get() = RoundedCornerShape(TandemTheme.radius.xl)

    internal val DefaultSelectedContainerColor: Color
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.colors.primaryContainer

    internal val DefaultSelectedContentColor: Color
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.colors.onPrimaryContainer

    internal val DefaultUnselectedContainerColor: Color
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.colors.secondary

    internal val DefaultUnselectedContentColor: Color
        @Composable
        @ReadOnlyComposable
        get() = TandemTheme.colors.onSecondary

    @Composable
    fun bottomBarColors(
        selectedContainerColor: Color = DefaultSelectedContainerColor,
        unselectedContainerColor: Color = DefaultUnselectedContainerColor,
        selectedContentColor: Color = DefaultSelectedContentColor,
        unselectedContentColor: Color = DefaultUnselectedContentColor
    ) = TandemTheme.colors.bottomBarColors.copy(
        selectedContainerColor = selectedContainerColor,
        unselectedContainerColor = unselectedContainerColor,
        selectedContentColor = selectedContentColor,
        unselectedContentColor = unselectedContentColor
    )

    @Composable
    fun bottomBarSpacing(
        floatingPadding: PaddingValues = PaddingValues(
            horizontal = DefaultHorizontalFloatingSpacing,
            vertical = DefaultVerticalFloatingSpacing
        ),
        contentPadding: PaddingValues = PaddingValues(
            all = DefaultContentSpacing
        )
    ): TandemUiBottomBarSpacing = TandemTheme.spacing.bottomBarSpacing.copy(
        floatingPadding = floatingPadding,
        contentPadding = contentPadding
    )

    private val TandemUiColors.bottomBarColors: TandemUiBottomBarColors
        @Composable
        @ReadOnlyComposable
        get() = LocalUiBottomBarColors.current

    private val TandemUiSpacing.bottomBarSpacing: TandemUiBottomBarSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalUiBottomBarSpacing.current

}