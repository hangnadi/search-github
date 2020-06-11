package com.hang.search.network

import com.hang.search.data.SearchUserEntity

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

class Repository() {

    suspend fun getListUsers(keyword: String): Result<SearchUserEntity?> {
        val services = Network.builder().create(GithubServices::class.java)
        val response = services.getListUser(keyword)

        return try {
            if (response.isSuccessful) {
                Result.Success(response.body())
            } else {
                Result.Error(Exception("github error"))
            }
        } catch (e : Exception) {
            Result.Error(Exception("network error"))
        }
    }

}