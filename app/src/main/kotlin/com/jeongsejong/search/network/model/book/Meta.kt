package com.jeongsejong.search.network.model.book

import com.google.gson.annotations.SerializedName


data class Meta(

    @SerializedName("is_end") var isEnd: Boolean? = null,
    @SerializedName("pageable_count") var pageableCount: Int? = null,
    @SerializedName("total_count") var totalCount: Int? = null

)