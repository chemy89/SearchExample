package com.jeongsejong.search.ui.book

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.jeongsejong.search.R
import com.jeongsejong.search.network.model.book.Documents

class BookAdapter(context: Context, books: ArrayList<Documents>) : RecyclerView.Adapter<BookAdapter.BookViewHolder?>() {
    private val context: Context
    private val books: ArrayList<Documents>

    init {
        this.context = context
        this.books = books
    }

    fun updateBooks(documents: ArrayList<Documents>?) {
        books.clear()
        books.addAll(documents!!)
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): BookViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_books, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: BookViewHolder, position: Int) {
        val model: Documents = books.get(position)
        holder.title.text = model.title
        holder.contents.text = model.contents
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BookViewHolder(@NonNull view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val contents: TextView

        init {
            title = view.findViewById(R.id.title)
            contents = view.findViewById(R.id.contents)
        }
    }

}