package com.app.dailynewsapp.ui.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.dailynewsapp.R
import com.app.dailynewsapp.adapters.NewsAdapter
import com.app.dailynewsapp.ui.MainActivity
import com.app.dailynewsapp.ui.NewsViewModel
import com.app.dailynewsapp.util.Resource
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_breaking_news.*


class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {
    private val TAGs: String?="TAG"
    lateinit var viewModel :NewsViewModel
lateinit var newsAdapter: NewsAdapter
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    viewModel=(activity as MainActivity).viewModel
setuprecyclkerview()
    newsAdapter.setOnItemClickListener {
        val bundle=Bundle().apply {
            putSerializable("article",it)

        }
        findNavController().navigate(
                R.id.action_breakingNewsFragment_to_articleFragment
        )
    }
    val itemTouchhelperCallback= object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.UP or ItemTouchHelper.DOWN

    ){
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            val article = newsAdapter.differ.currentList[position]
            viewModel.deleteArticle(article)
            Snackbar.make(view, "Deleted", 3000).apply {
                setAction("Undo") {
                    viewModel.saveArticle(article)
                }
                show()
            }
        }
    }
    viewModel.getsavedNews().observe(viewLifecycleOwner, Observer { articles ->
        newsAdapter.differ.submitList(articles)
    })


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
        Log.e(TAGs,"AnError Occured: $message")
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

