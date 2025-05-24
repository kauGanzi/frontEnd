package com.kau.ganzi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kau.ganzi.databinding.FragmentCivilhelpBinding
import com.kau.ganzi.view.activity.MainActivity
import com.kau.ganzi.view.adapter.ListAdapter

class CivilHelpFragment : Fragment() {

    private var _binding: FragmentCivilhelpBinding? = null
    private val binding get() = _binding!!

    private val civilHelpItems = listOf(
        "비대면 민원 상담",
        "원스톱 통합 서류 발급",
        "복지 혜택 신청 및 상담",
        "각종 세금 신고",
        "복지 혜택 신청 및 상담"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCivilhelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ListAdapter(civilHelpItems) { selectedItem ->
            // 클릭 시 로직 (예: Toast, Fragment 전환)
        }

        binding.buttonBack.setOnClickListener { (requireActivity() as MainActivity).replaceFragment(MainFragment()) }

        binding.recyclerViewCivilHelp.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
