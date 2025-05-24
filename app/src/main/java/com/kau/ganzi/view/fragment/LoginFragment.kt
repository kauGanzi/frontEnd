package com.kau.ganzi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.fragment.app.Fragment
import com.kau.ganzi.viewmodel.LoginViewModel
import com.kau.ganzi.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginResult.observe(viewLifecycleOwner) { result ->
            if (result == "성공") {

            }

            else {

            }
        }

        binding.buttonLogin.setOnClickListener {
            val id = binding.editTextId.text.toString()
            val pw = binding.editTextPw.text.toString()
            viewModel.login(id, pw)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
