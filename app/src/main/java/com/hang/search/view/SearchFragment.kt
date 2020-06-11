package com.hang.search.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hang.search.R
import com.hang.search.base.Visitable
import com.hang.search.data.SearchUserEntity
import com.hang.search.network.Result
import com.hang.search.view.recyclerview.SearchAdapter
import com.hang.search.view.recyclerview.SearchAdapterTypeFactory
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.*

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel
    private val adapterTypeFactory by lazy { SearchAdapterTypeFactory() }
    private val list by lazy { ArrayList<Visitable<*>>() }
    private val adapterView by lazy { SearchAdapter(adapterTypeFactory, list) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        viewModel.userData
            .observe(viewLifecycleOwner, Observer {
                when (it) {
                    is Result.Success -> updateRecyclerView(it.data)
                    is Result.Error -> showError(it.exception.message)
                }
            })
    }

    private fun updateRecyclerView(data: SearchUserEntity?) {
        Log.d(SearchFragment.javaClass.name, "updateRecyclerView: ")
    }

    private fun showError(message: String?) {
        Log.d(SearchFragment.javaClass.name, "showError: $message")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewResult.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = adapterView
        }

        adapterView.showLoading()

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (s != null) {
                    val keyword = s.toString()
                    viewModel.getUserLiveDataByKeyword(keyword)
                }
            }
        })
    }

}