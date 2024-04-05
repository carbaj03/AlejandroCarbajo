import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.skia.FilterBlurMode
import org.jetbrains.skia.MaskFilter

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun example() {
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    var color by remember {
      mutableStateOf(Color.Black)
    }
    var height by remember {
      mutableStateOf(80f)
    }
    var radius by remember {
      mutableStateOf(0f)
    }
    var shadowBorderRadius by remember {
      mutableStateOf(0f)
    }
    var offsetX by remember {
      mutableStateOf(12f)
    }
    var offsetY by remember {
      mutableStateOf(12f)
    }
    var spread by remember {
      mutableStateOf(7f)
    }
    var blurRadius by remember {
      mutableStateOf(0f)
    }
    var shadowColor by remember {
      mutableStateOf(Color.Magenta)
    }

    var text by remember { mutableStateOf("Hello World") }

    Column(
      modifier = Modifier
    ) {

      MyButton(
        modifier = Modifier.padding(0.dp),
        radius = radius,
        color = color,
        shadowColor = shadowColor,
        shadowBorderRadius = shadowBorderRadius,
        offsetX = offsetX,
        offsetY = offsetY,
        spread = spread,
        blurRadius = blurRadius
      ) {
        Text(
          text = text,
          modifier = Modifier.align(Alignment.CenterVertically),
          fontWeight = FontWeight.Bold,
          color = Color.White
        )
      }

      LazyColumn(
        modifier = Modifier
          .padding(50.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        stickyHeader {
          MyHeader("Geometry")
        }
        item {
          TextField(
            value = text,
            onValueChange = {
              text = it
            }
          )
        }
        item {
          ColorPicker {
            color = it
          }
        }
        item {
          MySlider(
            title = "Width",
            from = 0f,
            to = 200f,
            value = height,
            onValueChange = {
              height = it
            }
          )
        }
        item {
          MySlider(
            title = "Radius",
            from = 0f,
            to = 80f,
            value = radius,
            onValueChange = {
              radius = it
            }
          )
        }
        stickyHeader {
          MyHeader("Shadow")
        }
        item {
          MySlider(
            title = "Radius",
            from = 0f,
            to = 80f,
            value = shadowBorderRadius,
            onValueChange = {
              shadowBorderRadius = it
            }
          )
        }
        item {
          MySlider(
            title = "OffsetX",
            from = 0f,
            to = 80f,
            value = offsetX,
            onValueChange = {
              offsetX = it
            }
          )
        }
        item {
          MySlider(
            title = "OffsetY",
            from = 0f,
            to = 80f,
            value = offsetY,
            onValueChange = {
              offsetY = it
            }
          )
        }
        item {
          MySlider(
            title = "Spread",
            from = 0f,
            to = 80f,
            value = spread,
            onValueChange = {
              spread = it
            }
          )
        }
        item {
          MySlider(
            title = "Blur Radius",
            from = 0f,
            to = 80f,
            value = blurRadius,
            onValueChange = {
              blurRadius = it
            }
          )
        }
        stickyHeader {
          MyHeader("Shadow Color")
        }
        item {
          ColorPicker {
            shadowColor = it
          }
        }
      }
    }
  }
}

@Composable
fun MyButton(
  modifier: Modifier,
  radius: Float = 0f,
  color: Color = Color.Black,
  shadowColor: Color = Color.Black,
  shadowBorderRadius: Float = 0f,
  spread: Float = 0f,
  offsetX: Float = spread * 2,
  offsetY: Float = spread * 2,
  blurRadius: Float = 0f,
  contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
  content: @Composable RowScope.() -> Unit,
) {
  val interactionSource = remember { MutableInteractionSource() }
  val hover by interactionSource.collectIsHoveredAsState()
  val pressed by interactionSource.collectIsPressedAsState()
  val offsetXX by animateDpAsState(if (pressed) 0.dp else offsetX.dp)
  val offsetYY by animateDpAsState(if (pressed) 0.dp else offsetY.dp)
  val y by animateFloatAsState(if (pressed) spread else 0f)
  val spread2 by animateDpAsState(if (pressed) 0.dp else spread.dp)

  Row(
    modifier = modifier
      .graphicsLayer {
        translationY = y
      }
      .clickable(
        interactionSource = interactionSource,
        indication = rememberRipple(),
        enabled = true,
        onClick = {}
      )
      .shadow(
        color = shadowColor,
        borderRadius = shadowBorderRadius.dp,
        offsetX = offsetXX,
        offsetY = offsetYY,
        spread = spread2,
        blurRadius = blurRadius.dp
      )
      .defaultMinSize(
        minWidth = ButtonDefaults.MinWidth,
        minHeight = ButtonDefaults.MinHeight
      )
      .clip(RoundedCornerShape(radius.dp))
      .background(color)
      .padding(contentPadding)
  ) {
    content()
  }
}

@Composable
private fun MyHeader(
  title: String
) {
  Column() {
    Text(
      title,
      fontWeight = FontWeight.Black,
      modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(4.dp)
    )
  }
  Divider()
}

@Composable
fun ColorPicker(
  onColorChange: (Color) -> Unit
) {
  var hue by remember {
    mutableStateOf(0f)
  }
  var sat by remember {
    mutableStateOf(0f)
  }
  var value by remember {
    mutableStateOf(0f)
  }
  var alpha by remember {
    mutableStateOf(1f)
  }
  val color by remember {
    derivedStateOf {
      val c = Color.hsv(hue, sat, value, alpha)
      onColorChange(c)
      c
    }
  }
  Box(
    modifier = Modifier
      .size(20.dp)
      .clip(CircleShape)
      .background(color)
  )
  Text("Color:${color.value}")
  MySlider(title = "Hue", value = hue, to = 360f, onValueChange = { hue = it })
  MySlider(title = "Sat", value = sat, onValueChange = { sat = it })
  MySlider(title = "Val", value = value, onValueChange = { value = it })
  MySlider(title = "Alpha", value = alpha, onValueChange = { alpha = it })
}

@Composable
fun MySlider(
  title: String,
  from: Float = 0f,
  to: Float = 1f,
  value: Float,
  onValueChange: (Float) -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Text("$title:${value}")
    Slider(
      value = value,
      onValueChange = onValueChange,
      valueRange = from..to
    )
  }
}

fun Modifier.shadow(
  color: Color = Color.Black,
  borderRadius: Dp = 0.dp,
  blurRadius: Dp = 0.dp,
  offsetY: Dp = 0.dp,
  offsetX: Dp = 0.dp,
  spread: Dp = 0f.dp,
  modifier: Modifier = Modifier
) = this.then(
  modifier.drawBehind {
    this.drawIntoCanvas {
      val paint = Paint()
      val frameworkPaint = paint.asFrameworkPaint()
      val spreadPixel = spread.toPx()
      val leftPixel = (0f - spreadPixel) + offsetX.toPx()
      val topPixel = (0f - spreadPixel) + offsetY.toPx()
      val rightPixel = (this.size.width + spreadPixel)
      val bottomPixel = (this.size.height + spreadPixel)

      if (blurRadius != 0.dp) {
        frameworkPaint.maskFilter = MaskFilter.makeBlur(mode = FilterBlurMode.NORMAL, sigma = blurRadius.toPx())
      }

      frameworkPaint.color = color.toArgb()
      it.drawRoundRect(
        left = leftPixel,
        top = topPixel,
        right = rightPixel,
        bottom = bottomPixel,
        radiusX = borderRadius.toPx(),
        radiusY = borderRadius.toPx(),
        paint
      )
    }
  }
)