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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.Dimension
import com.uikit.component.text.TandemUiText
import com.uikit.foundation.theme.TandemTheme
import com.uikit.layout.TandemUiConstraintLayout
import com.uikit.layout.maxWidth
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
 * @param [showTitles] отображать ли подписи под иконками
 * @param [spacing] отступы для бара и контента
 * @param [colors] цвета для бара и контента
 * @param [shape] форма бара
 * @param [tonalElevation] возвышение бара над экраном
 *
 * @author Бережной Александр
 */
@Composable
fun <T> TandemUiBottomBar(
    items: List<TandemUiBottomBarItem<T>>,
    selectedRoute: T,
    onItemClick: (T) -> Unit,
    modifier: Modifier = Modifier,
    showTitles: Boolean = true,
    backgroundAlpha: Float = 0.93f,
    spacing: TandemUiBottomBarSpacing = TandemUiBottomBarDefaults.bottomBarSpacing(),
    colors: TandemUiBottomBarColors = TandemUiBottomBarDefaults.bottomBarColors(),
    shape: Shape = TandemUiBottomBarDefaults.DefaultShape,
    tonalElevation: Dp = TandemUiBottomBarDefaults.ContainerElevation
) {
    TandemUiConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(spacing.floatingPadding)
            .height(80.dp) // TODO: возможно стоит изменить подход: либо вынести в параметры, либо законстантить, либо исользовать modifier.heightIn()
            .shadow(
                elevation = tonalElevation,
                shape = shape,
                ambientColor = colors.unselectedContainerColor.copy(alpha = 0.2f),
                spotColor = colors.unselectedContainerColor.copy(alpha = 0.2f)
            )
            .padding(spacing.contentPadding)
            .clip(shape)
            .background(colors.unselectedContainerColor.copy(alpha = backgroundAlpha))
    ) { constraints ->
        val (indicatorBox, elementsRow) = createRefs()
        val itemWidth = maxWidth(
            constraints = constraints
        ) / items.size
        val selectedIndex = items.indexOfFirst { it.route == selectedRoute } - 1
        val indicatorOffset by animateDpAsState(
            targetValue = itemWidth * selectedIndex,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMediumLow
            ),
            label = "indicator-offset",
        )
        Box(
            modifier = Modifier
                .offset(x = indicatorOffset)
                .width(itemWidth)
                .fillMaxHeight()
                .padding(spacing.contentPadding)
                .clip(shape)
                .constrainAs(indicatorBox) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .background(colors.selectedContainerColor.copy(alpha = backgroundAlpha))
        )
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .constrainAs(elementsRow) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            items.forEach { item ->
                key(item.route.hashCode()) {
                    TandemUiBottomBarElement(
                        item = item,
                        isSelected = selectedRoute == item.route,
                        onClick = onItemClick,
                        itemWidth = itemWidth,
                        shape = shape,
                        showTitles = showTitles,
                        selectedContentColor = colors.selectedContentColor,
                        unselectedContentColor = colors.unselectedContentColor,
                    )
                }
            }
        }
    }
}

/**
 * # TandemUiBottomBar
 *
 * Нижний бар для навигации между вкладками с одной обособленной вкладкой справа
 *
 * [T] дженерик нужен для route'а навигации определенной вкладки
 *
 * TODO: на текущий момент есть проблема с тем что индикатор перекрывает контент элемента бара. Возможно поможет правильно расставить zIndex у элементов вёрстки
 *
 * @param [items] список вкладок
 * @param [leadingItem] вкладка справа
 * @param [selectedRoute] активаная вкладка
 * @param [onItemClick] действие при нажатии на вкладку
 * @param [modifier] модификатор для стилизации и разметки
 * @param [showTitles] отображать ли подписи под иконками
 * @param [spacing] отступы для бара и контента
 * @param [colors] цвета для бара и контента
 * @param [shape] форма бара
 * @param [tonalElevation] возвышение бара над экраном
 *
 * @author Бережной Александр
 */
@Composable
fun <T> TandemUiBottomBar(
    items: List<TandemUiBottomBarItem<T>>,
    leadingItem: TandemUiBottomBarItem<T>,
    selectedRoute: T,
    onItemClick: (T) -> Unit,
    modifier: Modifier = Modifier,
    showTitles: Boolean = true,
    backgroundAlpha: Float = 0.93f,
    spacing: TandemUiBottomBarSpacing = TandemUiBottomBarDefaults.bottomBarSpacing(),
    colors: TandemUiBottomBarColors = TandemUiBottomBarDefaults.bottomBarColors(),
    shape: Shape = TandemUiBottomBarDefaults.DefaultShape,
    tonalElevation: Dp = TandemUiBottomBarDefaults.ContainerElevation
) {
    TandemUiConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(spacing.floatingPadding)
            .height(80.dp) // TODO: возможно стоит изменить подход: либо вынести в параметры, либо законстантить, либо исользовать modifier.heightIn()
            .shadow(
                elevation = tonalElevation,
                shape = shape,
                ambientColor = colors.unselectedContainerColor.copy(alpha = 0.2f),
                spotColor = colors.unselectedContainerColor.copy(alpha = 0.2f)
            )
            .padding(spacing.contentPadding)
            .clip(shape)
            .background(Color.Transparent, shape = shape)
    ) { constraints ->
        val (indicatorBox, elementsRow, leadingItemButton) = createRefs()
        val itemWidth = maxWidth(
            constraints = constraints
        ) / (items.size + 1)
        val selectedIndex = items.indexOfFirst { it.route == selectedRoute }
        val indicatorOffset by animateDpAsState(
            targetValue = itemWidth * selectedIndex,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMediumLow
            ),
            label = "indicator-offset",
        )
        Box(
            modifier = Modifier
                .offset(x = indicatorOffset)
                .width(itemWidth)
                .fillMaxHeight()
                .padding(spacing.contentPadding)
                .clip(shape)
                .constrainAs(indicatorBox) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .background(colors.selectedContainerColor)
        )

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .constrainAs(elementsRow) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(leadingItemButton.start)
                    width = Dimension.fillToConstraints
                }
                .clip(shape)
                .background(colors.unselectedContainerColor.copy(alpha = backgroundAlpha)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            items.forEach { item ->
                key(item.route.hashCode()) {
                    TandemUiBottomBarElement(
                        item = item,
                        isSelected = selectedRoute == item.route,
                        onClick = onItemClick,
                        itemWidth = itemWidth,
                        shape = shape,
                        showTitles = showTitles,
                        selectedContentColor = colors.selectedContentColor,
                        unselectedContentColor = colors.unselectedContentColor,
                    )
                }
            }
        }

        TandemUiBottomBarElement(
            item = leadingItem,
            isSelected = false,
            onClick = { onItemClick(leadingItem.route) },
            itemWidth = itemWidth,
            modifier = Modifier
                .constrainAs(leadingItemButton) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(elementsRow.end)
                    end.linkTo(parent.end)
                }
                .background(colors.unselectedContainerColor.copy(alpha = backgroundAlpha)),
            shape = CircleShape,
            showTitles = false,
            unselectedContentColor = colors.unselectedContentColor
        )
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
 * @param [itemWidth] ширина элемента бара
 * @param [modifier] модификатор для стилизации и разметки
 * @param [shape] форма элемента бара
 * @param [showTitles] отображать ли подписи под иконками
 * @param [selectedContentColor] цвет контенка активной вкладки
 * @param [unselectedContentColor] цвет контента неактивной вкладки
 *
 * @author Бережной Александр
 */
@Composable
private fun <T> TandemUiBottomBarElement(
    item: TandemUiBottomBarItem<T>,
    isSelected: Boolean,
    onClick: (T) -> Unit,
    itemWidth: Dp,
    modifier: Modifier = Modifier,
    shape: Shape = TandemUiBottomBarDefaults.DefaultShape,
    showTitles: Boolean = true,
    selectedContentColor: Color = TandemUiBottomBarDefaults.DefaultSelectedContentColor,
    unselectedContentColor: Color = TandemUiBottomBarDefaults.DefaultUnselectedContentColor
) {
    Box(
        modifier = Modifier
            .width(itemWidth)
            .fillMaxHeight()
            .clip(shape)
            .clickable(
                interactionSource = null,
                indication = null,
                onClick = { onClick(item.route) }
            )
            .zIndex(2f)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
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
            if (showTitles) {
                // TODO: добавить Typography в тему и устанавливать здесь либо снаружи или по факту
                TandemUiText(
                    text = stringResource(item.titleStringResource),
                    color = color,
                    maxLines = 1
                )
            }
        }
    }
}
