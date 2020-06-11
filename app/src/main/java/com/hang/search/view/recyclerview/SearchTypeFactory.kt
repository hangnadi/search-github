package com.hang.search.view.recyclerview

import com.hang.search.data.UserData

interface SearchTypeFactory {

    fun type(userData: UserData):Int

}
