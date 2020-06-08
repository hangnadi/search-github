package com.hang.search.base

import android.view.View

interface TypeFactory {
    fun type(viewModel: LoadingModel): Int
    fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*>?
}