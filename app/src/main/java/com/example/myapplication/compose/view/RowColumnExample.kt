package com.example.myapplication.compose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blankj.utilcode.util.ToastUtils
import com.example.myapplication.R

/**
 * 同轴是   Arrangement
 * 交叉轴   Alignment
 */
@Composable
@Preview
fun ModifierExample() {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(100.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
//        Box(Modifier.size(100.dp)
//            .background(Color.Red)
//            .size(50.dp)
//            .padding(5.dp)
//            .combinedClickable(  // clickable 点击事件 、 combinedClickable 组合点击事件
//                indication = ripple(), //  水波纹效果
//                interactionSource = null, // 监听交互信息， 悬停
//                onClick = {},
//                onLongClick = {
//                    ToastUtils.showLong("长按了")
//                },
//                onDoubleClick = {}
//            ){
//                // 点击回调事件
//            })

        Box(Modifier.size(100.dp), contentAlignment = Alignment.Center) {
            Box(
                Modifier
                    .width(120.dp)
                    .background(Color.Red)
                    .horizontalScroll(rememberScrollState())
            ) { // 水平滚动
                Text(
                    text = "文本,Android Java Kotlin Compose",
                    modifier = Modifier.align(Alignment.Center), maxLines = 1
                )
            }
        }

    }
}

@Composable
@Preview
fun ButtonExample() {
    Column(
        modifier = Modifier
            .size(80.dp)
            .drawBehind {
                drawRect(Color.LightGray, topLeft = Offset(50f, 30f))
            },
    ) {
        Button(
            onClick = {
                ToastUtils.showLong("点击了按钮")
            }, modifier = Modifier
                .width(80.dp)
                .height(40.dp)
                .graphicsLayer {
                    transformOrigin = TransformOrigin(0.5f, 0f)
                    translationX = 20f // 平移
                    translationY = 40f
//                rotationZ = 30f // 旋转
//                scaleX = 0.5f // 缩放
                }
                .rotate(30f)
                .scale(0.5f)) {
            Text(text = "按钮", color = Color.Green)
        }
    }
}


// 【重组】：重新刷新界面以此来更新界面内容的这个过程我们称之为重组
@Preview
@Composable
fun DExample() {
    10.dp //
    val dp = with(LocalDensity.current) {
        10.dp.toPx()
        10.toDp() // 10 个像素转成 10 dp
    }
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color.Red, Color.Blue),
//                startX = 10f, // 渐变起始位置 dp 单位
//                endX = 10f
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .shadow(elevation = 20.dp)  // 阴影
                .background(Color.Yellow, CutCornerShape(8.dp))
        )
    }
}


@Preview
@Composable
fun PaddingExample() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
//            .padding(end = 5.dp)  //  padding 盒子， 在 size 前，类似于 margin
                .size(30.dp)
                .background(Color.Red)
                .padding(5.dp)  // 内边距 。在 size 后，类似于 padding
                .background(Color.Green.copy(0.5f))
                .border(2.dp, Color.Blue), contentAlignment = Alignment.Center
        ) {
            Text(text = "我在这", style = TextStyle(fontSize = 5.sp))
        }
    }

}


// Modifier ：修饰器
// 1、更改可组合项的大小、布局、行为、和外观
// 2、添加信息，如无障碍标签
// 3、处理用户输入
// 4、添加高级互动，如使用元素可点击、可滚动、可拖动、可缩放等

@Preview(showBackground = true)
@Composable
fun DemoExample() {
    Box(
        Modifier
            .width(60.dp)
            .height(90.dp)
//            .background(Color.Green)
    ) {
        Column {
            Box(
                Modifier
//                .wrapContentWidth() // 特殊用途：包裹内容宽度

//            .aspectRatio(ratio = 4f) // 宽高比
                    .size(50.dp)
                    .background(Color.Red, CircleShape)
            ) {
                Box(
                    Modifier
//                .size(55.dp) // size 不能突破父布局约束
                        .requiredSize(55.dp) // 强制大小，可以突破父布局约束
                        .background(Color.Yellow.copy(0.4f))
                )
            }

            Spacer(
                Modifier
                    .height(10.dp)
                    .background(Color.Cyan)
                    .fillMaxWidth()
            )

            // 权重 ，只在主轴上有效
            Row(
                Modifier
//                    .fillMaxHeight(0.8f)
                    .height(10.dp)
                    .background(Color.Red)
            ) {
                Box(
                    Modifier
                        .padding(end = 5.dp)
                        .fillMaxHeight()
                        .weight(3f) // 权重
                        .background(Color.Green)
                )

                Box(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(Color.Yellow)
                )

            }
        }

        // matchParentSize ： 匹配父布局大小
        // Box(Modifier.matchParentSize().background(Color.Magenta))

    }
}


//  图片组件
@Preview(showBackground = true)
@Composable
fun ImageExample(
    modifier: Modifier = Modifier,
    size: Dp = 50.dp,  // 图片大小
    imageRes: Int = R.drawable.map01,  // 图片资源
) {
    Box(
        modifier
            .size(size)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(size),
            contentScale = ContentScale.Fit,    // 裁剪方式
            colorFilter = ColorFilter.tint(Color.Red) // PNG 图片，着色器
        )
    }
}


@Composable
fun TextExample(
    onClick: (() -> Unit)? = null,  // 点击事件
) {  // 富文本
    Text(
        buildAnnotatedString {
            withStyle(
                SpanStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            ) {
                append("同意")
            }

            // 添加点击时事件
            withLink(
                LinkAnnotation.Clickable(
                    tag = "link"
                ) {
                    onClick?.invoke()
                }) {
                withStyle(
                    SpanStyle(
                        fontSize = 12.sp,
                        color = Color.Green
                    )
                ) {
                    append("《山子用户协议》")
                    appendInlineContent("图片")
                }
            }


            withStyle(
                SpanStyle(
                    fontSize = 8.sp,
                    color = Color.Black
                )
            ) {
                append("后才能使用")
            }
        }, inlineContent = mapOf(
            "图片" to InlineTextContent(
                Placeholder(
                    width = 10.sp,
                    height = 10.sp,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.map01),
                    contentDescription = null
                )
            }
        )
    )

}

@Preview(showBackground = true)
@Composable
fun PreviewTextExample() {
    TextExample()
}


@Preview(showBackground = true)
@Composable
fun BoxExample() {
    Row(
        Modifier
            .width(100.dp), horizontalArrangement = Arrangement.Center
    ) {
        Text(
            "文字a",
            fontWeight = FontWeight.Black,
            minLines = 2,
            style = TextStyle(fontSize = 10.sp, color = Color.Red, textAlign = TextAlign.Right),
            modifier = Modifier.background(Color.Blue)
        )
    }
}


@Preview
@Composable
fun RowExample() {
    Row(
        Modifier
            .width(200.dp)
            .height(60.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.Top
    ) {
        ColorBox(modifier = Modifier, size = 50.dp, Color.Red)
        ColorBox(modifier = Modifier, 20.dp, Color.Green)
        ColorBox(modifier = Modifier, 30.dp, Color.Blue)
    }
}

@Composable
private fun ColorBox(modifier: Modifier = Modifier, size: Dp, color: Color) {
    Box(
        modifier
            .size(size)
            .background(color),
    ) {
        Text(
            text = "Hello",
            fontSize = 8.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}