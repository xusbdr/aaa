package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jes.wikiworld.databinding.FragmentMenuBinding



class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnSalirMenu.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_creditFragment)
        }

        binding.btnVolverLogin.setOnClickListener {
            findNavController().popBackStack(R.id.loginFragment, false)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}