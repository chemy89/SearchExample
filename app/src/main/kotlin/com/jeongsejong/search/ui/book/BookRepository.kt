package com.jeongsejong.search.ui.book

import com.jeongsejong.search.network.ApiProvider
import com.jeongsejong.search.network.api.BookApi
import com.jeongsejong.search.network.model.book.Books
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BookRepository() {
    private val api = ApiProvider.createService(BookApi::class.java)

    fun requestSearchBooks(): Observable<Books> = api
        .requestBookList("미움받을 용기", "accuracy", 1, 10)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}