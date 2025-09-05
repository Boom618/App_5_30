package com.example.myapplication.compose.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.tooling.preview.Preview

/**
 * 副作用：函数执行过程中，会改变函数外部的变量
 */

// 纯函数
fun pureFunction(value: Int): String {
    return value.toString()
}

// 对外部有进行 读取 修改 的函数 输出 log 也是副作用

@Composable
@Preview
fun SideEffectExample() {
    var num by remember { mutableIntStateOf(0) }

    Column {
        SideEffect {
            Log.d("临时测试", "重组成功1次")
        }
        Text(num.toString())
        Button(onClick = {
            num++
        }) {
            Text("点击")
        }
    }

}

class MyUser(
    val uid: Int,
    val name: String
)

class UserUtils() {
    var curUid: Int = 0

    fun doSomething() {
    }
}

@Composable
fun rememberUserUtils(): UserUtils {
    val userUtils = remember {
        UserUtils()
    }
    return userUtils
}

@Composable
fun MyUserFunctionScope(user: MyUser) {
    val userUtils = rememberUserUtils()

    //
    SideEffect {
        userUtils.curUid = user.uid
    }

    LaunchedEffect(Unit) {

    }

    Button(onClick = {
        userUtils.doSomething()
    }) {

    }
}

// snapshotFlow 作用：将 Compose 的状态转换为 Kotlin Flow
@Composable
@Preview
fun SnapshotFlowExample() {
    var num by remember { mutableIntStateOf(0) }
    val flow = snapshotFlow { num }

    LaunchedEffect(Unit) {
        val flow = snapshotFlow { num }
    }

}

