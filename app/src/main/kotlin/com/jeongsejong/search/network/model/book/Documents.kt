package com.jeongsejong.search.network.model.book

import com.google.gson.annotations.SerializedName


data class Documents(

    @SerializedName("authors") var authors: ArrayList<String> = arrayListOf(),
    @SerializedName("contents") var contents: String? = null,
    @SerializedName("datetime") var datetime: String? = null,
    @SerializedName("isbn") var isbn: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("publisher") var publisher: String? = null,
    @SerializedName("sale_price") var salePrice: Int? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("translators") var translators: ArrayList<String> = arrayListOf(),
    @SerializedName("url") var url: String? = null

)