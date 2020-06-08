package com.hang.search.base

import android.view.View

open class AdapterTypeFactory : TypeFactory {

    override fun type(viewModel: LoadingModel): Int {
        return LoadingViewHolder.LAYOUT
    }

    override fun createViewHolder(
        parent: View,
        type: Int
    ): AbstractViewHolder<*> {
        return when (type) {
            LoadingViewHolder.LAYOUT -> LoadingViewHolder(parent)
            else -> throw RuntimeException()
        }
    }
}