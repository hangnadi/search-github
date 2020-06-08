package com.hang.search.view.recyclerview

import android.view.View
import com.hang.search.R
import com.hang.search.base.AbstractViewHolder
import com.hang.search.view.model.UserModel

class UserViewHolder (itemView: View) : AbstractViewHolder<UserModel>(itemView) {

    companion object {
        const val LAYOUT = R.layout.recyclerview_item_loading
    }

    override fun bind(model: UserModel) {

    }
}
