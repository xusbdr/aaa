package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailItemFragment : Fragment() {

    private var itemName: String? = null
    private var itemDescription: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_deatail_item, container, false)

        // Obtener referencias a los TextViews
        val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)

        // Establecer los datos del elemento en los TextViews
        itemName?.let { nameTextView.text = it }
        itemDescription?.let { descriptionTextView.text = it }

        return view
    }

    // Función para establecer los datos del elemento
    fun setItemData(name: String, description: String) {
        itemName = name
        itemDescription = description
    }
}
