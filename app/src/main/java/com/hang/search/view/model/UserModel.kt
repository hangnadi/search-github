package com.hang.search.view.model

import com.hang.search.base.Visitable
import com.hang.search.view.recyclerview.SearchTypeFactory

class UserModel : Visitable<SearchTypeFactory> {

    override fun type(typeFactory: SearchTypeFactory): Int {
        return typeFactory.type(this)
    }

}