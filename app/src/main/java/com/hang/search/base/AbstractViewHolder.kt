package com.hang.search.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class AbstractViewHolder<T : Visitable<*>?>(itemView: View) :
    ViewHolder(itemView) {
    abstract fun bind(element: T)
}