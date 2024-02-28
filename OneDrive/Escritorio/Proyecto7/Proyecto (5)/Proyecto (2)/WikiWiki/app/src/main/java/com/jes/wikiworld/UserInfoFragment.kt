package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jes.wikiworld.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Acceder a las vistas del diseño y establecer la información del usuario
        binding.username.text = "Usuario123"
        binding.email.text = "usuario@example.com"

        // Puedes obtener más información del usuario y mostrarla según tus necesidades
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
