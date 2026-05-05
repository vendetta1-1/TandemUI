package com.uikit.tokens.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

/**
 * # TandemUiTypography
 *
 * Константы шрифтов
 *
 * @author Бережной Александр
 */
@Immutable
data class TandemUiTypography(
    val displayLarge: TextStyle = TandemUiTypographyTokens.DisplayLarge,
    val displayMedium: TextStyle = TandemUiTypographyTokens.DisplayMedium,
    val displaySmall: TextStyle = TandemUiTypographyTokens.DisplaySmall,
    val headlineLarge: TextStyle = TandemUiTypographyTokens.HeadlineLarge,
    val headlineMedium: TextStyle = TandemUiTypographyTokens.HeadlineMedium,
    val headlineSmall: TextStyle = TandemUiTypographyTokens.HeadlineSmall,
    val titleLarge: TextStyle = TandemUiTypographyTokens.TitleLarge,
    val titleMedium: TextStyle = TandemUiTypographyTokens.TitleMedium,
    val titleSmall: TextStyle = TandemUiTypographyTokens.TitleSmall,
    val bodyLarge: TextStyle = TandemUiTypographyTokens.BodyLarge,
    val bodyMedium: TextStyle = TandemUiTypographyTokens.BodyMedium,
    val bodySmall: TextStyle = TandemUiTypographyTokens.BodySmall,
    val labelLarge: TextStyle = TandemUiTypographyTokens.LabelLarge,
    val labelMedium: TextStyle = TandemUiTypographyTokens.LabelMedium,
    val labelSmall: TextStyle = TandemUiTypographyTokens.LabelSmall
)