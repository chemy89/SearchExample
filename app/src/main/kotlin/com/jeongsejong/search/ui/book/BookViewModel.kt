package com.jeongsejong.search.ui.book

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jeongsejong.search.network.model.book.Books
import com.jeongsejong.search.ui.book.BookRepository

/**
 *
 * @author jeongsejong
 * @date 2022/06/07
 *
 */
class BookViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: BookRepository = BookRepository()
    var booksResult: MutableLiveData<Books> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun requestSearchBooks() {
        repo.requestSearchBooks().subscribe(
            { ResultRequestSearchBooks ->
                booksResult.value = ResultRequestSearchBooks
            }, {
                val message = if(it.message != null) {
                    it.message
                } else {
                    "empty message"
                }
                Log.e("Error!", message!!)
            })

    }

}
