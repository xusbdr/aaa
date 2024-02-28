package com.jes.wikiworld
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComentariosAdapter(private val comments: MutableList<Comment>) : RecyclerView.Adapter<ComentariosAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val currentComment = comments[position]
        holder.bind(currentComment)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val authorTextView: TextView = itemView.findViewById(R.id.author)
        private val contentTextView: TextView = itemView.findViewById(R.id.content)

        fun bind(comment: Comment) {
            authorTextView.text = comment.author
            contentTextView.text = comment.content

            // Configurar el clic del botón de eliminación
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    comments.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }
}