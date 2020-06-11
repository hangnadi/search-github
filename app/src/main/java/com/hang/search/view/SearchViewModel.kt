package com.hang.search.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hang.search.data.SearchUserEntity
import com.hang.search.network.Repository
import com.hang.search.network.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel() : ViewModel() {

    private val userMutablelLiveData = MutableLiveData<Result<SearchUserEntity?>>()
    private val repository = Repository()
    val userData : LiveData<Result<SearchUserEntity?>>
        get() = userMutablelLiveData

    fun getUserLiveDataByKeyword(keyword: String) {
        viewModelScope.launch {
            delay(500)
            val result = repository.getListUsers(keyword)
            userMutablelLiveData.value = result
        }
    }
}