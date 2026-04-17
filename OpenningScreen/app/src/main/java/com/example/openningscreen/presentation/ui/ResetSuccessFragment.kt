package com.example.openningscreen.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.R
import com.example.openningscreen.databinding.FragmentResetsuccessBinding
import com.example.openningscreen.presentation.viewmodel.SuccessViewModel

class ResetSuccessFragment : Fragment() {
    private lateinit var binding: FragmentResetsuccessBinding
    private val viewModel: SuccessViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resetsuccess, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentResetsuccessBinding.bind(view)

        setOnCLick()
        obseverData()
    }

    private fun setOnCLick() {
        binding.backToLogin.setOnClickListener {
            viewModel.loginClick()
        }
    }

    private fun obseverData() {
        //NavigationLogin
        viewModel.uiState.observe(viewLifecycleOwner) { isVisible ->
            if (isVisible.navigationLogin) {
                findNavController().navigate(R.id.layout7_layout2)
                viewModel.doneLogin()
            }
        }
    }


}