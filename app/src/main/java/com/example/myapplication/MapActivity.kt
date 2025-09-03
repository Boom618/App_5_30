package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.compose.setContent

class MapActivity : AppCompatActivity() {


    val TAG = "MapActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{

        }



    }

}

@Composable
@Preview
fun DefaultPreview() {

    Text(text = "Hello World!")
}