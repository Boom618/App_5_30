package com.example.myapplication.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        Log.i("NotificationsFragment", "onCreateView")


//        binding.imageView.background = ContextCompat.getDrawable(requireContext(), R.drawable.phone_edit_bg)
//        binding.imageView1.background = ContextCompat.getDrawable(requireContext(), R.drawable.card_1)
//        binding.imageView2.background = ContextCompat.getDrawable(requireContext(), R.drawable.card_2)
//        binding.imageView3.background = ContextCompat.getDrawable(requireContext(), R.drawable.card_3)
//        binding.imageView4.background = ContextCompat.getDrawable(requireContext(), R.drawable.card_4)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("NotificationsFragment", "onDestroyView")

        binding.imageView.background = null
        binding.imageView1.background = null
        binding.imageView2.background = null
        binding.imageView3.background = null
        binding.imageView4.background = null

        _binding = null
    }
}