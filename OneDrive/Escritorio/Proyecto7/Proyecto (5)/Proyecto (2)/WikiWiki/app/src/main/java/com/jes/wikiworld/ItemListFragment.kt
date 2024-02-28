package com.jes.wikiworld

import ItemAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jes.wikiworld.Item


class ItemListFragment : Fragment() {

    private val items: MutableList<Item> = mutableListOf() // Lista de elementos
    private lateinit var adapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Asignación de la vista RecyclerView
        recyclerView = view.findViewById(R.id.recy)

        // Inicializar RecyclerView y su adaptador
        adapter = ItemAdapter(items)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Agregar elementos de muestra
        items.addAll(getSampleItems())




        // Acceder al botón
        val addToFavoritesButton: Button = view.findViewById(R.id.adde)
        addToFavoritesButton.setOnClickListener {

        }

        return view
    }

    private fun getSampleItems(): List<Item> {
        // Retorna una lista de elementos de muestra
        return listOf(
            Item(1, "Elemento 1", "Descripción del elemento 1"),
            Item(2, "Elemento 2", "Descripción del elemento 2"),
            Item(3, "Elemento 3", "Descripción del elemento 3")
        )
    }
}