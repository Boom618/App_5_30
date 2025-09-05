package com.example.myapplication.compose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * compose 状态及其使用
 */

@Composable
fun TeacherInfo(modifier: Modifier = Modifier, name: String, school: String, year: Int) {
    Column(
        modifier.background(Color.Red)
    ) {
        Text(text = name)
        Text(text = school)
        Text(text = "$year")
    }
}

@Stable // 标记该方法是稳定的
data class UnStableData(
    var name: String
)


@Composable
@Preview
fun StateExample() {

    // by 委托，是对 get  set  方法
    val numList = remember {
        mutableStateListOf<Int>()
    }

    var currentNum = remember { mutableIntStateOf(0) }

}


@Composable
fun CompositionExample(num: Int) {
    Text(
        text = "$num",
        Modifier
            .background(Color.White)
            .requiredSize(50.dp),
        style = TextStyle(
            color = Color.Red, fontSize = 20.sp
        )
    )
}