package com.app.dailynewsapp.models

import com.app.dailynewsapp.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)