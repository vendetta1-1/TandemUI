package com.uikit.component.progress.circular

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.uikit.tokens.progress.circular.TandemUiCircularProgressBarColors
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun TandemUiCircularProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    diameter: Dp = TandemUiCircularProgressBarDefaults.DefaultDiameter,
    strokeWidth: Dp = TandemUiCircularProgressBarDefaults.DefaultStrokeWidth,
    colors: TandemUiCircularProgressBarColors = TandemUiCircularProgressBarDefaults.circularProgressBarColors(),
    revealDurationMs: Int = TandemUiCircularProgressBarDefaults.DefaultRevealDurationMs,
    label: String? = null
) {
    val target = progress.coerceIn(0f, 1f)
    val animated = remember {
        Animatable(0f)
    }

    LaunchedEffect(target) {
        animated.animateTo(
            targetValue = target,
            animationSpec = tween(
                durationMillis = revealDurationMs,
                easing = FastOutSlowInEasing
            )
        )
    }

    Box(
        modifier = Modifier
            .size(diameter)
            .progressSemantics(animated.value)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        ProgressRing(
            progress = animated.value,
            strokeWidth = strokeWidth,
            trackColor = colors.trackColor,
            gradientColors = colors.gradientColors,
            glowColor = colors.glowColor,
            coreColor = colors.coreColor
        )

        label?.let {
            ProgressLabel(
                progress = animated.value,
                label = it,
                color = colors.contentColor
            )
        }
    }
}

@Composable
private fun ProgressRing(
    progress: Float,
    strokeWidth: Dp,
    trackColor: Color,
    gradientColors: List<Color>,
    glowColor: Color,
    coreColor: Color,
) {
    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val strokeWidthPx = strokeWidth.toPx()

        val inset = strokeWidthPx / 2f

        val arcSize = Size(
            width = size.width - strokeWidthPx,
            height = size.height - strokeWidthPx,
        )

        val topLeft = Offset(
            x = inset,
            y = inset
        )

        val center = Offset(
            x = size.width / 2f,
            y = size.height / 2f,
        )

        drawTrack(
            color = trackColor,
            strokeWidth = strokeWidthPx,
            topLeft = topLeft,
            size = arcSize
        )

        if (progress > 0f && gradientColors.isNotEmpty()) {
            val sweep = 360f * progress

            drawProgressArc(
                colors = gradientColors,
                center = center,
                strokeWidth = strokeWidthPx,
                topLeft = topLeft,
                size = arcSize,
                sweep = sweep
            )

            drawHeadGlow(
                center = center,
                radius = (size.width - strokeWidthPx) / 2f,
                strokeWidth = strokeWidthPx,
                sweep = sweep,
                glowColor = glowColor,
                coreColor = coreColor
            )
        }
    }
}

@Composable
private fun ProgressLabel(
    progress: Float,
    label: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${(progress * 100).toInt()}%",
            color = color,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label
        )
    }
}

private fun DrawScope.drawTrack(
    color: Color,
    strokeWidth: Float,
    topLeft: Offset,
    size: Size
) {
    drawArc(
        color = color,
        startAngle = 0f,
        sweepAngle = 360f,
        useCenter = false,
        topLeft = topLeft,
        size = size,
        style = Stroke(width = strokeWidth)
    )
}

private fun DrawScope.drawProgressArc(
    colors: List<Color>,
    center: Offset,
    strokeWidth: Float,
    topLeft: Offset,
    size: Size,
    sweep: Float
) {
    rotate(
        degrees = -90f,
        pivot = center
    ) {
        drawArc(
            brush = Brush.sweepGradient(
                colors = colors,
                center = center
            ),
            startAngle = 0f,
            sweepAngle = sweep,
            useCenter = false,
            topLeft = topLeft,
            size = size,
            style = Stroke(
                width = strokeWidth,
                cap = StrokeCap.Butt
            )
        )
    }
}

private fun DrawScope.drawHeadGlow(
    center: Offset,
    radius: Float,
    strokeWidth: Float,
    sweep: Float,
    glowColor: Color,
    coreColor: Color
) {
    val angleRadius = (((sweep + -90f) * PI) / 180.0).toFloat()
    val headOffset = Offset(
        x = center.x + radius * cos(angleRadius),
        y = center.y + radius * sin(angleRadius)
    )

    drawCircle(
        color = glowColor,
        radius = strokeWidth / 2f + 2f,
        center = headOffset
    )

    drawCircle(
        color = coreColor,
        radius = strokeWidth / 2.2f,
        center = headOffset
    )
}