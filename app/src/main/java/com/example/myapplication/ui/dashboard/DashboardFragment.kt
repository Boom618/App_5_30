package com.example.myapplication.ui.dashboard

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentDashboardBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.Locale
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.coroutines.EmptyCoroutineContext

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.textDashboard.setOnClickListener {
            Toast.makeText(it.context, "切换语言", Toast.LENGTH_SHORT).show()
            setLocale(it.context,"en")
            binding.mediaName.setTextSize(TypedValue.COMPLEX_UNIT_PX,24f)
        }
        return root
    }




    fun setLocale(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val resources = context.resources
        val configuration = Configuration(resources.configuration)

        configuration.setLocale(locale)

        context.createConfigurationContext(configuration)
    }

    fun test(){

        val thread = thread(start = false) {

        }

        thread.start()
        thread.join(1000)

        val  executor = Executors.newCachedThreadPool()
        executor.execute {

        }

        val  scope = CoroutineScope(EmptyCoroutineContext)
        scope.launch {

        }


    }









    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}