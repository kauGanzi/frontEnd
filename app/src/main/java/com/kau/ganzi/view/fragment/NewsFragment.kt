package com.kau.ganzi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.kau.ganzi.databinding.FragmentNewsBinding
import com.kau.ganzi.model.News
import com.kau.ganzi.view.activity.MainActivity

class NewsFragment(private val news: News) : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.news = news // 바인딩에 뉴스 객체 넘김
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonBack.setOnClickListener { (requireActivity() as MainActivity).replaceFragment(MainFragment())}

        // 이미지 로드 (Glide 예제)
        Glide.with(this)
            //.load("")
            //.into(binding.imageViewNews)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
