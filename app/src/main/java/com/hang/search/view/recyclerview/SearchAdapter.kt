package com.hang.search.view.recyclerview

import com.hang.search.base.BaseAdapter
import com.hang.search.base.LoadingModel
import com.hang.search.base.Visitable
import com.hang.search.data.UserData
import java.util.*

class SearchAdapter(
    adapterTypeFactory: SearchAdapterTypeFactory,
    visitables: ArrayList<Visitable<*>>
) : BaseAdapter<SearchAdapterTypeFactory>(adapterTypeFactory, visitables) {

    private val loadingModel by lazy { LoadingModel() }

    fun showLoading() {
        if (!visitables.contains(loadingModel)) {
            visitables.add(loadingModel)
            notifyItemInserted(visitables.size)
        }
    }

    fun dismissLoading() {
        if (visitables.contains(loadingModel)) {
            visitables.remove(loadingModel)
            notifyItemRemoved(visitables.size)
        }
    }

    fun setData(items: List<UserData>) {
        visitables = items
        notifyDataSetChanged()
    }

}

