package com.app.dailynewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.app.dailynewsapp.R
import com.app.dailynewsapp.ui.MainActivity
import com.app.dailynewsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*


class ArticleFragment : Fragment(R.layout.fragment_article) {
lateinit var viewModel: NewsViewModel
val args:ArticleFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    viewModel=(activity as MainActivity).viewModel
    val article=args.article
webView.apply {
    webViewClient= WebViewClient()
    loadUrl(article.url)


}
        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view,"Success",3000).show()



        }

    }
}