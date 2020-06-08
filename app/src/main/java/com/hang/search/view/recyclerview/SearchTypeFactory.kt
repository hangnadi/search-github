package com.hang.search.view.recyclerview

import com.hang.search.view.model.UserModel

interface SearchTypeFactory {

    fun type(userModel: UserModel):Int

}
