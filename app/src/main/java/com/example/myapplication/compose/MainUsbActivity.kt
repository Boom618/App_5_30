package com.example.myapplication.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.compose.view.CompositionExample

class MainUsbActivity : AppCompatActivity() {

//    var num = 0
    // 策略1：结构性相等（默认）， 比较值是否相等，类似 equals 两个等号 ==
    // 策略2：引用相等，比较引用地址是否相等 =》 三个等号  ===
    // 策略3：永不相等，任何情况都不相等
    val numState = mutableIntStateOf(0)
    // 采用委托属性，获取到 numState.value  的值，不再是 numState 对象


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCompose()
        }
    }
}



class Student(name: String, age: Int){
    var name by mutableStateOf(name)
    var age by mutableIntStateOf(age)
}

//  Ctrl + Alt + M ：方法提取
@Composable
private fun MyCompose() {
    Column(Modifier
        .fillMaxSize()
        .background(Color.White)) {
        // 需要 remember 保存变量，Compose 是函数，没有成员变量，函数内部的变量均为临时变量，每次运行后都会销毁；
        // 类才有成员变量
//             var num = mutableIntStateOf(0)
//            ZLog.i("num: ${num.hashCode()}")
        var num by remember { mutableIntStateOf(0) }

        // 当 num 发生改变时，Student 都会被创建，带 remember(key) 的方式，
        // 只关注 key 【num】 改变才会创建或者刷新，
        val student = remember(num) { Student("张三", num) }
        val student1 = Student("张三", num)

        CompositionExample(num = num)
        Text(text = "名字: ${student.name} , 年龄: ${student.age}")
        Box(
            Modifier
                .size(30.dp)
                .background(Color.Red)
                .clickable {
                    num++
                }
        )
    }
}