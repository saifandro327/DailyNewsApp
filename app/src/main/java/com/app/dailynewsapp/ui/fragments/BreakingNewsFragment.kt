package com.app.dailynewsapp.ui.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.dailynewsapp.R
import com.app.dailynewsapp.adapters.NewsAdapter
import com.app.dailynewsapp.ui.MainActivity
import com.app.dailynewsapp.ui.NewsViewModel
import com.app.dailynewsapp.util.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*


class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {
lateinit var viewModel :NewsViewModel
lateinit var newsAdapter: NewsAdapter
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    viewModel=(activity as MainActivity).viewModel
setuprecyclkerview()
    viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response -> when(response){
        is Resource.Success ->{
             hideProgressBar()
            response.data?.let {
                newsResponse ->
                newsAdapter.differ.submitList(newsResponse.articles)

            }
        }
is Resource.Error ->{
    hideProgressBar()
    response.message?.let { message->
        Log.e(TAG,"AnError Occured: $message")
    }

}
        is Resource.Loading -> {
            showProgressBar()
        }
    } })
    }

    private fun hideProgressBar() {
paginationProgresbar.visibility=View.INVISIBLE
    }
    private fun showProgressBar() {
        paginationProgresbar.visibility=View.VISIBLE
    }

    private fun setuprecyclkerview(){
    newsAdapter = NewsAdapter()
    rvBreakingNews.apply {
        newsAdapter=newsAdapter
        layoutManager=LinearLayoutManager(activity)

    }
}
}

