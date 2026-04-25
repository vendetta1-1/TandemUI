package com.uikit.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.uikit.foundation.theme.TandemTheme

/**
 * # TandemUiText
 *
 * Обёртка над [Text] для исключения большого количества ненужных параметров
 *
 * @param [text] отображаемый текст
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
fun TandemUiText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TandemTheme.colors.onPrimary,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) {
    Text(
        text = text,
        color = color,
        modifier = modifier,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        style = style
    )
}