package com.jeongsejong.search.network.api

import com.jeongsejong.search.network.model.book.Books
import com.jeongsejong.search.network.model.book.Documents
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query


interface BookApi {

    /**
     * 책 정보 조회
     *
     */
    @GET("book")
    fun requestBookList(@HeaderMap headers: Map<String, String>,
                        @Query("query") query: String,
                        @Query("sort") sort: String,
                        @Query("page") page: Int,
                        @Query("size") size: Int): Observable<Books>


}