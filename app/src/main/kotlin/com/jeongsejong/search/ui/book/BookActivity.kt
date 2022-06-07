package com.jeongsejong.search.ui.book

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeongsejong.search.R
import com.jeongsejong.search.databinding.ActivityBookBinding
import com.jeongsejong.search.helper.PreferenceManager
import org.koin.android.ext.android.inject

class BookActivity : AppCompatActivity() {
    private val preferenceManager: PreferenceManager by inject()

    private lateinit var binding: ActivityBookBinding
    private val bookViewModel: BookViewModel by viewModels()
    private val mAdapter: BookAdapter = BookAdapter(this, ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_book)
        binding.bookViewModel = bookViewModel
        binding.bookRecyclerView.layoutManager = LinearLayoutManager(this@BookActivity)
        binding.bookRecyclerView.adapter = mAdapter
        binding.lifecycleOwner = this

        observeViewModel()

        bookViewModel.requestSearchBooks()
    }

    private fun observeViewModel() {
        bookViewModel.booksResult.observe(this) {
            mAdapter.updateBooks(it.documents)
        }
    }

}