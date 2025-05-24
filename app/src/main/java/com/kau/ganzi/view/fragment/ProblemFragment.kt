package com.kau.ganzi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.fragment.app.Fragment
import com.kau.ganzi.R
import com.kau.ganzi.databinding.FragmentProblemBinding
import com.kau.ganzi.view.activity.MainActivity
import com.kau.ganzi.viewmodel.ProblemViewModel

class ProblemFragment : Fragment() {
    private var _binding: FragmentProblemBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProblemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProblemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener { (requireActivity() as MainActivity).replaceFragment(MainFragment())}

        viewModel.loadProblem()

        viewModel.problem.observe(viewLifecycleOwner) { problem ->
            if (problem != null) {
                binding.textViewProblem.text = problem.question

                binding.buttonOption1.text = problem.choices[0]
                binding.buttonOption2.text = problem.choices[1]
                binding.buttonOption3.text = problem.choices[2]
                binding.buttonOption4.text = problem.choices[3]
            }

            else {
                binding.textViewProblem.text = getString(R.string.error)

                binding.buttonOption1.text = ""
                binding.buttonOption2.text = ""
                binding.buttonOption3.text = ""
                binding.buttonOption4.text = ""
            }
        }

        viewModel.isCorrect.observe(viewLifecycleOwner) { isCorrect ->
            if (isCorrect == null || !isCorrect) {

                viewModel.loadProblem()
            }

            else {

            }
        }

        binding.buttonOption1.setOnClickListener {
            viewModel.checkAnswer(0)
        }

        binding.buttonOption2.setOnClickListener {
            viewModel.checkAnswer(1)
        }

        binding.buttonOption3.setOnClickListener {
            viewModel.checkAnswer(2)
        }

        binding.buttonOption4.setOnClickListener {
            viewModel.checkAnswer(3)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
