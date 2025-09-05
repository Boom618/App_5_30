package com.example.myapplication.compose.view

import android.annotation.SuppressLint
import android.util.Log
import android.widget.TextView
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetTextI18n")
@Composable
@Preview
fun InteroperabilityExample() {
    var num by remember { mutableIntStateOf(0) }
    var num2 by remember { mutableIntStateOf(0) }

    AndroidView(factory = {
        TextView(it).apply {
            textSize = 20f
        }
    }, update = {
        Log.i("Log", "update")
        it.text = "num: $num"
    }, onRelease = {
        Log.i("Log", "onRelease")
    })

    Button(onClick = {num++}) {
        Text(text = " 点我 num 加 1")
    }


}