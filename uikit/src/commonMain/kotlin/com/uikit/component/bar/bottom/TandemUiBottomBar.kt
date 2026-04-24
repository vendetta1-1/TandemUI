package com.uikit.component.bar.bottom

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.uikit.component.text.TandemUiText
import com.uikit.foundation.theme.TandemTheme
import com.uikit.tokens.bar.bottom.TandemUiBottomBarColors
import com.uikit.tokens.bar.bottom.TandemUiBottomBarSpacing
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

/**
 * # TandemUiBottomBar
 *
 * Нижний бар для навигации между вкладками
 *
 * [T] дженерик нужен для route'а навигации определенной вкладки
 *
 * @param [items] список вкладок
 * @param [selectedRoute] активаная вкладка
 * @param [onItemClick] действие при нажатии на вкладку
 * @param [modifier] модификатор для стилизации и разметки
 * @param [spacing] отсупы для бара и контента
 * @param [colors] цвета для бара и контента
 * @param [shape] форма бара
 * @param [tonalElevation] возвышение бара над экраном
 */
@Composable
fun <T> TandemUiBottomBar(
    items: List<TandemUiBottomBarItem<T>>,
    selectedRoute: T,
    onItemClick: (T) -> Unit,
    modifier: Modifier = Modifier,
    spacing: TandemUiBottomBarSpacing = TandemUiBottomBarDefaults.bottomBarSpacing(),
    colors: TandemUiBottomBarColors = TandemUiBottomBarDefaults.bottomBarColors(),
    shape: Shape = TandemUiBottomBarDefaults.DefaultShape,
    tonalElevation: Dp = TandemUiBottomBarDefaults.ContainerElevation
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.floatingPadding)
            .height(70.dp) // TODO: возможно стоит изменить подход: либо вынести в параметры, либо законстантить, либо исользовать modifier.heightIn()
            .shadow(
                elevation = tonalElevation,
                shape = shape,
                ambientColor = colors.selectedContainerColor.copy(alpha = 0.3f),
                spotColor = colors.selectedContainerColor.copy(alpha = 0.3f)
            )
            .clip(shape)
            .background(colors.unselectedContainerColor)
            .padding(spacing.contentPadding),
        contentAlignment = Alignment.Center,
    ) {
        val itemWidth = maxWidth / items.size
        val selectedIndex = items.indexOfFirst { it.route == selectedRoute } - 1
        val indicatorOffset by animateDpAsState(
            targetValue = itemWidth * selectedIndex,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMediumLow,
            ),
            label = "indicator-offset",
        )

        Box(
            modifier = Modifier
                .offset(x = indicatorOffset)
                .width(itemWidth)
                .fillMaxHeight()
                .clip(shape)
                .background(colors.selectedContainerColor),
        )
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            items.forEach { item ->
                Box(
                    modifier = Modifier
                        .width(itemWidth)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    TandemUiBottomBarElement(
                        item = item,
                        isSelected = selectedRoute == item.route,
                        onClick = onItemClick,
                        selectedContentColor = colors.selectedContentColor,
                        unselectedContentColor = colors.unselectedContentColor,
                    )
                }
            }
        }
    }
}

/**
 * # TandemUiBottomBarElement
 *
 * Элемент нижнего бара, вкладка
 *
 * [T] дженерик нужен для route'а навигации определенной вкладки
 *
 * @param [item] вкладка для навигации
 * @param [isSelected] является ли эта вкладка активной
 * @param [onClick] действие при нажатии на вкладку
 * @param [selectedContentColor] цвет контенка активной вкладки
 * @param [unselectedContentColor] цвет контента неактивной вкладки
 */
@Composable
private fun <T> TandemUiBottomBarElement(
    item: TandemUiBottomBarItem<T>,
    isSelected: Boolean,
    onClick: (T) -> Unit,
    selectedContentColor: Color = TandemUiBottomBarDefaults.DefaultSelectedContentColor,
    unselectedContentColor: Color = TandemUiBottomBarDefaults.DefaultUnselectedContentColor
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .padding(
                vertical = TandemTheme.spacing.sm,
                horizontal = TandemTheme.spacing.xs
            )
            .clickable(
                interactionSource = null,
                indication = null,
                onClick = { onClick(item.route) }
            )
    ) {
        val color by animateColorAsState(
            targetValue = if (isSelected) selectedContentColor else unselectedContentColor,
            animationSpec = tween(
                durationMillis = TandemTheme.duration.fast,
                easing = LinearEasing
            )
        )
        Icon(
            painter = painterResource(item.iconDrawableResource),
            tint = color,
            contentDescription = stringResource(item.titleStringResource),
            modifier = Modifier.size(TandemTheme.iconSize.sm)
        )
        // TODO: добавить Typography в тему и устанавливать здесь либо снаружи или по факту
        TandemUiText(
            text = stringResource(item.titleStringResource),
            color = color,
            maxLines = 1
        )
    }
}
