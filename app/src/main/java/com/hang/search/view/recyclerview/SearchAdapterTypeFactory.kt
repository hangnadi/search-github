package com.hang.search.view.recyclerview

import android.view.View
import com.hang.search.base.AbstractViewHolder
import com.hang.search.base.AdapterTypeFactory
import com.hang.search.data.UserData

class SearchAdapterTypeFactory : AdapterTypeFactory(), SearchTypeFactory {

    override fun type(userData: UserData): Int {
        return UserViewHolder.LAYOUT
    }

    override fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*> {
        return  when (type) {
            UserViewHolder.LAYOUT -> UserViewHolder(parent)
            else -> super.createViewHolder(parent, type)
        }
    }

}
