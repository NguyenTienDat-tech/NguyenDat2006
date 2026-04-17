package com.example.openningscreen.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.R
import com.example.openningscreen.databinding.FragmentWelcomeBinding
import com.example.openningscreen.presentation.viewmodel.WelcomeViewModel
import kotlin.getValue


class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentWelcomeBinding.bind(view)

        setOnClick()
        obseverData()
    }

    private fun setOnClick() {
        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.layout2)
        }
        binding.createAccount.setOnClickListener {
            findNavController().navigate(R.id.layout3)
        }
    }

    private fun obseverData() {
        viewModel.uiState.observe(viewLifecycleOwner) { isVisible ->
            //NavigationLogin
            if (isVisible.navigationLogin) {
                findNavController().navigate(R.id.layout7_layout2)
                viewModel.doneLogin()
            }

            //NavigationRegister
            if (isVisible.navigationRegister) {
                findNavController().navigate(R.id.layout3)
                viewModel.doneRegister()
            }
        }
    }
}