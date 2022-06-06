package com.jeongsejong.search.network.model.book

import com.google.gson.annotations.SerializedName


data class Books(

    @SerializedName("documents") var documents: ArrayList<Documents> = arrayListOf(),
    @SerializedName("meta") var meta: Meta? = Meta()

)