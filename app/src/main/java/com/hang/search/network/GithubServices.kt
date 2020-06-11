package com.hang.search.network

import com.hang.search.data.SearchUserEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubServices {

    @GET("search/users")
    suspend fun getListUser(@Query("q") keyword: String): Response<SearchUserEntity>

}