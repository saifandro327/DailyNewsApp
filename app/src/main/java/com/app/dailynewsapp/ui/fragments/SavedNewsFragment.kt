package com.app.dailynewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.dailynewsapp.R
import com.app.dailynewsapp.adapters.NewsAdapter
import com.app.dailynewsapp.ui.MainActivity
import com.app.dailynewsapp.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_breaking_news.*


class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    lateinit var viewModel : NewsViewModel

lateinit var newsAdapter:NewsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewModel
        setuprecyclkerview()
        newsAdapter.setOnItemClickListener {
            val bundle=Bundle().apply {
                putSerializable("article",it)

            }
            findNavController().navigate(
                    R.id.action_savedNewsFragment_to_articleFragment
            )
        }

    }
    private fun setuprecyclkerview(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            newsAdapter=newsAdapter
            layoutManager= LinearLayoutManager(activity)

        }
    }
}