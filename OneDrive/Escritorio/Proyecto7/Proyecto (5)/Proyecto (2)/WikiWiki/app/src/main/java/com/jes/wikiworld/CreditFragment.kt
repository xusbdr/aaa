package com.jes.wikiworld


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jes.wikiworld.databinding.FragmentCreditBinding


class CreditFragment : Fragment() {


    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_USER_NAME = "userName"

        fun newInstance(userName: String): CreditFragment {
            val fragment = CreditFragment()
            val args = Bundle().apply {
                putString(ARG_USER_NAME, userName)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        val view = binding.root

        val userName = arguments?.getString(ARG_USER_NAME) ?: ""
        binding.userInfoText.text = "Usuario $userName estás usando la versión 1 de la aplicación"


        binding.buttonContact.setOnClickListener {
            val subject = "Consulta de la app WikiWorld" // Asunto del correo electrónico
            val message = "Escribe tu mensaje aquí..." // Cuerpo del correo electrónico

            // Crear un intent implícito de envío de correo electrónico
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822" // Tipo de contenido MIME para correo electrónico
                putExtra(Intent.EXTRA_EMAIL, arrayOf("tu@email.com")) // Dirección de correo electrónico de destino
                putExtra(Intent.EXTRA_SUBJECT, subject) // Asunto del correo electrónico
                putExtra(Intent.EXTRA_TEXT, message) // Cuerpo del correo electrónico
            }

            // Verificar si hay aplicaciones que pueden manejar el intent implícito
            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(Intent.createChooser(intent, "Enviar correo electrónico")) // Mostrar el selector de aplicaciones para enviar correo electrónico
            } else {
                // Manejar el caso en el que no haya aplicaciones que puedan manejar el intent implícito
                Toast.makeText(requireContext(), "No se encontró ninguna aplicación para enviar correo electrónico", Toast.LENGTH_SHORT).show()
            }
        }





        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}