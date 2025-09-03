package com.example.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.myapplication.R

class ImageAdapter(private val context: Context, private val items: List<Int>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)

        val item = items[position]

        val imageView = view.findViewById<ImageView>(R.id.image)


//        Glide.with(context).load(item).into(imageView)
         imageView.setImageResource(item)


//        imageView.background = context.getDrawable(item)
//        val drawable = context.getDrawable(item)
//        val bitmap = (drawable as BitmapDrawable).bitmap
//        // bitmap 所占字节大小
//        val sizeBitmap = bitmap.allocationByteCount
//        Log.i("ImageAdapter", "原 bitmap size: $sizeBitmap")
//
//        val argb565Bitmap = bitmap.copy(Bitmap.Config.RGB_565, false)
//        val bitmap2 = argb565Bitmap.allocationByteCount
//        Log.i("ImageAdapter", "bitmap2 size: $bitmap2")
//
//        imageView.setImageBitmap(argb565Bitmap)

//        val decodeBitmap = ImageUtil.decodeSampledBitmapFromResource(context.resources, item, 1920, 1080)
//        val sizeBitmap2 = decodeBitmap.allocationByteCount
//        Log.i("ImageAdapter", "sizeBitmap2 : $sizeBitmap2")

        // 原 bitmap size: 1632432
        // sizeBitmap2 : 408960


        return view
    }
}