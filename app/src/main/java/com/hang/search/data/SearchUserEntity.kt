package com.hang.search.data
import com.google.gson.annotations.SerializedName


data class SearchUserEntity(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<UserData>,
    @SerializedName("total_count")
    val totalCount: Int
)
