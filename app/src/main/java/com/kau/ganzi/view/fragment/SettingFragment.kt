package com.kau.ganzi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kau.ganzi.databinding.FragmentSettingBinding
import com.kau.ganzi.view.activity.MainActivity
import com.kau.ganzi.view.adapter.ListAdapter

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    private val settingItems = listOf(
        "개인정보 수정",
        "알림 설정",
        "목소리 설정",
        "글씨 설정",
        "크레딧"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ListAdapter(settingItems) { selectedItem ->
            // 각 항목 클릭 시 로직
            // 예: (requireActivity() as MainActivity).replaceFragment(OtherFragment())
        }

        binding.buttonBack.setOnClickListener { (requireActivity() as MainActivity).replaceFragment(MainFragment())}

        binding.recyclerViewSetting.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
