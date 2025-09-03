package com.example.myapplication

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        lifecycleScope.launch {
            val initJob = launch {
                //  initial()
            }
            async {

            }
            // 协程交互：
            initJob.join()
            // 当该方法依赖 initial 协程时，可以用 join 等待，join 无返回值, async 有返回结果
            // processData()

            // 挂起 回调函数
            val result = suspendCoroutine {
                // 挂起函数的回调
                it.resume(1)
            }
        }
        display()

    }

    private fun display(){
        // 获取 DisplayMetrics 实例
        val displayMetrics = DisplayMetrics()
        // windowManager.defaultDisplay.getMetrics(displayMetrics) // 屏幕尺寸，去除导航栏
        windowManager.defaultDisplay.getRealMetrics(displayMetrics) // 屏幕真实尺寸



        val displayMetrics1 = resources.displayMetrics
        val widthPixels1 = displayMetrics1.widthPixels
        val heightPixels1 = displayMetrics1.heightPixels

        Log.i(TAG, "resources 屏幕宽度 (像素): $widthPixels1")
        Log.i(TAG, "resources 屏幕高度 (像素): $heightPixels1")
        Log.i(TAG, "------------------------------")

        val defaultDisplay = windowManager.defaultDisplay
        val width = defaultDisplay.width
        val height = defaultDisplay.height
        Log.i(TAG, "windowManager 屏幕宽度 (像素): $width")
        Log.i(TAG, "windowManager 屏幕高度 (像素): $height")
        Log.i(TAG, "------------------------------")

        // 获取屏幕宽度和高度（像素）
        val widthPixels = displayMetrics.widthPixels
        val heightPixels = displayMetrics.heightPixels

        // 获取屏幕宽度和高度（dp）
        val widthDp = widthPixels / displayMetrics.density
        val heightDp = heightPixels / displayMetrics.density

        // 获取屏幕密度
        val density = displayMetrics.density
        val densityDpi = displayMetrics.densityDpi

        // 打印屏幕尺寸和分辨率
        Log.i(TAG, "getRealMetrics 屏幕宽度 (像素): $widthPixels")
        Log.i(TAG, "getRealMetrics 屏幕高度 (像素): $heightPixels")
        Log.i(TAG, "屏幕宽度 (dp): $widthDp")
        Log.i(TAG, "屏幕高度 (dp): $heightDp")
        Log.i(TAG, "density  : $density")
        Log.i(TAG, "densityDpi  : $densityDpi")
    }
}