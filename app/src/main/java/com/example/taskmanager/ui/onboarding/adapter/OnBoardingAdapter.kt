package com.example.taskmanager.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager.R
import com.example.taskmanager.databinding.ItemOnboardingBinding
import com.example.taskmanager.model.OnBoardingModel

class OnBoardingAdapter(private val onClick:()-> Unit):RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf<OnBoardingModel>(
        OnBoardingModel(R.drawable.img1,"TaskManager","TaskManagerDescription"),
        OnBoardingModel(R.drawable.img_1,"TaskManager","TaskManagerDescription"),
        OnBoardingModel(R.drawable.img3,"TaskManager","TaskManagerDescription")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding):ViewHolder(binding.root){
        fun bind(onBoardingModel: OnBoardingModel){
            onBoardingModel.image?.let { binding.ivBoard.setImageResource(it) }
            binding.tvTitle.text = onBoardingModel.title
            binding.tvDesc.text=onBoardingModel.desc
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.tvSkip.isVisible = adapterPosition != data.lastIndex
            binding.tvSkip.setOnClickListener {
                onClick()
            }
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }
    }



}