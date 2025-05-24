package com.kau.ganzi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kau.ganzi.R
import com.kau.ganzi.databinding.FragmentMainBinding
import com.kau.ganzi.view.activity.MainActivity
import com.kau.ganzi.view.adapter.BannerAdapter
import com.kau.ganzi.view.adapter.MainAdapter

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 1️⃣ 상단 배너 ViewPager 설정
        bannerAdapter = BannerAdapter(listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
        ))
        binding.viewPagerBanner.adapter = bannerAdapter

        // RecyclerView 버튼 목록 준비
        // 버튼 추가가 필요하면 여기서 하드 코딩
        val buttonTexts = listOf(
            "사용 설명서", "학습하기", "AI와 대화",
            "관공서 연결", "앱 정보", "준비중"
        )

        // 3️⃣ 어댑터 생성 (버튼 클릭 처리 로직)
        mainAdapter = MainAdapter(buttonTexts) { clickedText ->
            when (clickedText) {
                "사용 설명서" -> (requireActivity() as MainActivity).replaceFragment(ManualFragment())
                "학습하기" -> (requireActivity() as MainActivity).replaceFragment(ProblemFragment())
                // "AI와 대화" -> (requireActivity() as MainActivity).replaceFragment(AIChatFragment())
                // "관공서 연결" -> (requireActivity() as MainActivity).replaceFragment(ManualFragment())
                // "앱 정보" -> (requireActivity() as MainActivity).replaceFragment(ManualFragment())
                // "준비중" -> (requireActivity() as MainActivity).replaceFragment(ManualFragment())

                else -> {
                    // 아무것도 안함
                }
            }
        }

        // 4️⃣ RecyclerView를 Grid 레이아웃으로 배치
        binding.recyclerViewMain.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mainAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}