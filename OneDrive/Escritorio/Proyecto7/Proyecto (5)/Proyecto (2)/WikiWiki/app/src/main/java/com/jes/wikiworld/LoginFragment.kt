package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jes.wikiworld.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var nombre: Nombre
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        nombre = Nombre.getInstance()

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            nombre.setUserName(username)

            // Navegar al fragmento MenuFragment
            findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
