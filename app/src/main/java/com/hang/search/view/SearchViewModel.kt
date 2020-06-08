package com.hang.search.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hang.search.data.UserData
import java.util.ArrayList

class SearchViewModel : ViewModel() {

    lateinit var userModelLiveData: MutableLiveData<ArrayList<UserData>>

    fun getUserLiveDataByKeyword(keyword: String): MutableLiveData<ArrayList<UserData>> {
        return userModelLiveData
    }
}