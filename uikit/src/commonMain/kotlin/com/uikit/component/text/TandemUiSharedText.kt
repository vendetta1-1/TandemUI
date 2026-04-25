package com.uikit.component.text

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.BoundsTransform
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SharedTransitionDefaults
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

/**
 * # TandemUiSharedText
 *
 * [Text] с анимацией перехода между экранами
 *
 * @param [text] отображаемый текст
 * @param [sharedTransitionScope] скоуп для анимации перехода
 * @param [animatedVisibilityScope] скоуп для анимации видимости
 * @param [sharedTransitionKey] ключ для сопоставления элемента на исходном экране с элементом на следующем экране
 * @param [modifier] модификатор для стилизации и разметки
 * @param [color] цвет текста
 * @param [style] стиль текста
 * @param [textAlign] выравнивание текста внутри его контейнера
 * @param [maxLines] максимальное количество строк отображаемого текста на экране
 * @param [overflow] стратегия при невозможности разместить текст в доступной ширине или высоте
 *
 * @author Бережной Александр
 */
@Composable
fun TandemUiSharedText(
    text: String,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionKey: Any,
    modifier: Modifier = Modifier,
    boundsTransform: BoundsTransform = SharedTransitionDefaults.BoundsTransform,
    enter: EnterTransition = EnterTransition.None,
    exit: ExitTransition = ExitTransition.None,
    resizeMode: SharedTransitionScope.ResizeMode = SharedTransitionScope.ResizeMode.scaleToBounds(),
    color: Color = MaterialTheme.colorScheme.onPrimary,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) {
    with(sharedTransitionScope) {
        TandemUiText(
            text = text,
            color = color,
            modifier = modifier.sharedBounds(
                sharedContentState = rememberSharedContentState(sharedTransitionKey),
                animatedVisibilityScope = animatedVisibilityScope,
                enter = enter,
                exit = exit,
                boundsTransform = boundsTransform,
                resizeMode = resizeMode,
            ),
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            style = style
        )
    }
}
