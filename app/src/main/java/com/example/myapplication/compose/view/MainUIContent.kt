package com.example.myapplication.compose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * 自定义 组件
 */
@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun MainUIContent(
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit)? = null // 设置可空的参数
) {
    // modifier : 单例对象
    Column(modifier) {
        Row {
            Text(text = "USB")
            Text(text = "1234")
        }
        content?.invoke()
    }
}

//@Preview
//@Composable
//fun SimpleComposablePreview() {
//    MainUIContent()
//}