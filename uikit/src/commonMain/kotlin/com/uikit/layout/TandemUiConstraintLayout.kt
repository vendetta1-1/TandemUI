package com.uikit.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.core.widgets.Optimizer

/**
 * # TandemUiConstraintLayout
 *
 * Layout с возможностью привязки элементов друг к другу
 *
 * @param [modifier] модификатор для стилизации и разметки
 * @param [optimizationLevel] уровень оптимизации
 * @param [content] контент внутри layout
 *
 * @author Бережной Александр
 */
@Composable
fun TandemUiConstraintLayout(
    modifier: Modifier = Modifier,
    optimizationLevel: Int = Optimizer.OPTIMIZATION_STANDARD,
    content: @Composable ConstraintLayoutScope.(constraints: Constraints) -> Unit
) {
    SubcomposeLayout(
        modifier = modifier
    ) { constraints ->
        val measurables = subcompose(Unit) {
            ConstraintLayout(
                modifier = Modifier,
                optimizationLevel = optimizationLevel
            ) {
                content(constraints)
            }
        }
        val placeable = measurables.first().measure(constraints)
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}


@Composable
fun ConstraintLayoutScope.maxWidth(
    constraints: Constraints
): Dp = with(LocalDensity.current) {
    if (constraints.hasBoundedWidth) constraints.maxWidth.toDp() else Dp.Infinity
}

@Composable
fun ConstraintLayoutScope.maxHeight(
    constraints: Constraints
): Dp = with(LocalDensity.current) {
    if (constraints.hasBoundedWidth) constraints.maxHeight.toDp() else Dp.Infinity
}

@Composable
fun ConstraintLayoutScope.minWidth(
    constraints: Constraints
): Dp = with(LocalDensity.current) {
    return constraints.minWidth.toDp()
}

@Composable
fun ConstraintLayoutScope.minHeight(
    constraints: Constraints
): Dp = with(LocalDensity.current) {
    return constraints.minHeight.toDp()
}