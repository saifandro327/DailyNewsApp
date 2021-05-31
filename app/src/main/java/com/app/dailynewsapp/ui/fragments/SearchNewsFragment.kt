package com.app.dailynewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dailynewsapp.R
import com.app.dailynewsapp.ui.MainActivity
import com.app.dailynewsapp.ui.NewsViewModel


class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {
    lateinit var viewModel : NewsViewModel
 
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewModel

    }
}