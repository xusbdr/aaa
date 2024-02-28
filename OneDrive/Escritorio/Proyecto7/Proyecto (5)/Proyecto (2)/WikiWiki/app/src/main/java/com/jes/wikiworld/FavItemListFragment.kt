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
import com.jes.wikiworld.databinding.FragmentFavItemListBinding
import com.jes.wikiworld.Item

class FavItemListFragment : Fragment() {



    private val favoriteItems = mutableListOf<Item>()
    private lateinit var adapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fav_item_list, container, false)
        recyclerView = view.findViewById(R.id.favItemListFragment)
        adapter = ItemAdapter(favoriteItems)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        favoriteItems.addAll(getSampleItems())
        val backButton: Button = view.findViewById(R.id.btnVolverAtras)
        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        adapter.setOnDeleteClickListener { item ->
            favoriteItems.remove(item)
            adapter.notifyDataSetChanged()
        }
        return view
    }

    private fun getSampleItems(): List<Item> {
        return listOf(
            Item(1, "Alpinismo", "Descripción del favorito 1"),
            Item(2, "Running", "Descripción del favorito 2"),
            Item(3, "Senderismo", "Descripción del favorito 3"),
            Item(4, "Ciclismo", "Descripción del favorito 3")
        )
    }
}