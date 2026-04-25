package com.uikit.component.bar.bottom

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

/**
 * # TandemUiBottomBarItem
 *
 * Класс описывающий 1 вкладку для нижнего бара
 *
 * @param [titleStringResource] строковый ресурс для отображения текста
 * @param [iconDrawableResource] drawable ресурс для отображения иконки вкладки
 * @param [route] route для навигации
 *
 * @author Бережной Александр
 */
data class TandemUiBottomBarItem<out T>(
    val titleStringResource: StringResource,
    val iconDrawableResource: DrawableResource,
    val route: T,
)

