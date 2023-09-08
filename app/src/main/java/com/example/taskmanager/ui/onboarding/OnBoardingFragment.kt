package com.example.taskmanager.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.R
import com.example.taskmanager.databinding.FragmentOnBoardingBinding
import com.example.taskmanager.ui.onboarding.adapter.OnBoardingAdapter


class OnBoardingFragment : Fragment() {
    lateinit var adapter :OnBoardingAdapter

    private lateinit var binding: FragmentOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = OnBoardingAdapter(this::onClick)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpeger.adapter = adapter
        binding.circleindecator.setViewPager(binding.viewpeger)


    }
    private fun onClick(){
        findNavController().navigate(R.id.navigation_home)
    }

}