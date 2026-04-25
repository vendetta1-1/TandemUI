package com.uikit.tokens.bar.bottom

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * # TandemUiBottomBarSpacing
 *
 * Класс, описывающий цвета нижнего бара
 *
 * @param [selectedContainerColor] цвет контейнера активной вкладки
 * @param [unselectedContainerColor] цвет контейнера неактивной вкладки
 * @param [selectedContentColor] цвет контента активной вкладки
 * @param [unselectedContentColor] цвет контента неактивной вкладки
 *
 * @see com.uikit.component.bar.bottom.TandemUiBottomBar
 *
 * @author Бережной Александр
 */
@Immutable
data class TandemUiBottomBarColors(
    val selectedContainerColor: Color,
    val unselectedContainerColor: Color,
    val selectedContentColor: Color,
    val unselectedContentColor: Color
)