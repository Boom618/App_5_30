package com.example.myapplication.ui

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log

object ImageUtil {

    fun decodeSampledBitmapFromResource(
        res: Resources,
        resId: Int,
        reqWidth: Int = 1920,
        reqHeight: Int = 1080
    ): Bitmap {
        // 第一次解析将 inJustDecodeBounds 设置为 true，来获取图片大小
        val options = BitmapFactory.Options().apply {
            inJustDecodeBounds = true
        }
        BitmapFactory.decodeResource(res, resId, options)

        // 调用计算 inSampleSize 方法
        options.inSampleSize = 2

        // 使用获取到的 inSampleSize 再次解析图片
        options.inJustDecodeBounds = false
        return BitmapFactory.decodeResource(res, resId, options)
    }

    fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
        // 源图片的高度和宽度
        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {
            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2

            // 计算最大的 inSampleSize 值是 2 的指数，并且使得图片的高度和宽度都大于请求的高度和宽度。
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }
        Log.i("ImageUtil", "inSampleSize: $inSampleSize")
        return inSampleSize
    }

}