import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jes.wikiworld.Item2
import com.jes.wikiworld.R

class ItemAdapter2(private val items: List<Item2>) : RecyclerView.Adapter<ItemAdapter2.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val addToFavoritesButton: Button = itemView.findViewById(R.id.adde)

        fun bind(item: Item2) {

            descriptionTextView.text = item.description

            addToFavoritesButton.setOnClickListener {
                // Lógica para agregar el elemento a "Favoritos"
                addToFavorites(item)
            }
        }

        // Definición de la función addToFavorites
        private fun addToFavorites(item: Item2) {
            // Aquí puedes implementar la lógica para agregar el elemento a la lista de "Favoritos"
        }
    }
}
