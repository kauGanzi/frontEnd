package com.kau.ganzi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kau.ganzi.databinding.FragmentManualBinding
import com.kau.ganzi.view.activity.MainActivity
import com.kau.ganzi.view.adapter.ManualAdapter

class ManualFragment : Fragment() {
    private var _binding: FragmentManualBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManualBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val texts = listOf(
            "김노인 사용자님, 안녕하세요!",
            "지금 보고 계시는 화면은 '사용 설명서'입니다. 내용을 천천히 읽어보며 따라 해 주세요.",
            "글자가 읽기 어렵다면, 위의 동영상을 재생하거나 오른쪽 위 '목소리 버튼'을 눌러 보세요."
        )

        val adapter = ManualAdapter(texts)
        binding.recyclerViewManual.adapter = adapter
        binding.buttonBack.setOnClickListener { (requireActivity() as MainActivity).replaceFragment(MainFragment()) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
