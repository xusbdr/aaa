package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jes.wikiworld.databinding.FragmentDetailFavItemBinding



class DetailFavItemFragment : Fragment() {

    private var _binding: FragmentDetailFavItemBinding? = null
    private val binding get() = _binding!!

    private lateinit var comentariosAdapter: ComentariosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailFavItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView y su adaptador
        comentariosAdapter = ComentariosAdapter(getSampleComments().toMutableList())
        binding.commentsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = comentariosAdapter
        }

        // Configurar acción para el botón flotante
        binding.addCommentButton.setOnClickListener {
            // Aquí puedes implementar la lógica para añadir un nuevo comentario
            // Esto puede incluir abrir un cuadro de diálogo, navegar a otra pantalla, etc.
        }
    }

    private fun getSampleComments(): List<Comment> {
        return listOf(
            Comment("Autor 1", "Contenido del comentario 1"),
            Comment("Autor 2", "Contenido del comentario 2"),
            Comment("Autor 3", "Contenido del comentario 3")
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}