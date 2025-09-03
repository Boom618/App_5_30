package com.example.myapplication.ui.home

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.adapter.ImageAdapter
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



//    val iconList = arrayListOf<Int>(R.drawable.app88,R.drawable.app88,R.drawable.app88,R.drawable.app88,R.drawable.app88,
//        R.drawable.app88,R.drawable.app88,R.drawable.app88,R.drawable.app88,R.drawable.app88,
//        R.drawable.app88,R.drawable.app88,R.drawable.app88,R.drawable.app88,R.drawable.app88,
//        R.drawable.app88,R.drawable.app88,R.drawable.app88,R.drawable.app88,R.drawable.app88)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root



        loadData()
        return root
    }


    private fun loadData() {
//       binding.listItem.adapter = ImageAdapter(binding.root.context, iconList)
//       binding.listItem.adapter = ImageAdapter(binding.root.context, iconSvg)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}