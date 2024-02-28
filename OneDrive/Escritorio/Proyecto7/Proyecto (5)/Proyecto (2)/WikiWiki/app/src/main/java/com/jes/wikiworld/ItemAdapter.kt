


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jes.wikiworld.Item
import com.jes.wikiworld.R

class ItemAdapter(private val items: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var onDeleteClickListener: ((Item) -> Unit)? = null
    private val selectedItems: MutableSet<Item> = mutableSetOf()

    // Método para establecer el listener del clic en el botón de eliminar
    fun setOnDeleteClickListener(listener: (Item) -> Unit) {
        onDeleteClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem, selectedItems.contains(currentItem))

        holder.itemView.setOnClickListener {
            toggleSelection(currentItem)
        }
    }

    override fun getItemCount(): Int = items.size

    // Método para obtener el elemento seleccionado
    fun getSelectedItems(): List<Item> {
        return selectedItems.toList()
    }

    // Método para alternar la selección de un elemento
    private fun toggleSelection(item: Item) {
        if (selectedItems.contains(item)) {
            selectedItems.remove(item)
        } else {
            selectedItems.add(item)
        }
        notifyItemChanged(items.indexOf(item))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val deleteButton: Button = itemView.findViewById(R.id.deleteButton)

        fun bind(item: Item, isSelected: Boolean) {
            nameTextView.text = item.name
            descriptionTextView.text = item.description
            itemView.isActivated = isSelected



        }
    }
}
