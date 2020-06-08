package com.hang.search.base

import android.view.View
import com.hang.search.R

class LoadingViewHolder(itemView: View) : AbstractViewHolder<LoadingModel>(itemView) {

    companion object {
        const val LAYOUT = R.layout.recyclerview_item_loading
    }

    override fun bind(model: LoadingModel) {

    }
}

class LoadingModel : Visitable<TypeFactory> {
    override fun type(typeFactory: TypeFactory): Int {
        return typeFactory.type(this)
    }
}
