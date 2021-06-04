package com.app.dailynewsapp.repository

import com.app.dailynewsapp.api.RetrofitInstance
import com.app.dailynewsapp.db.ArticleDatabase
import com.app.dailynewsapp.models.Article

class NewsRepository (
    val db : ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
            RetrofitInstance.api.getTopNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery:String, pageNumber:Int) =
            RetrofitInstance.api.searchNews(searchQuery, pageNumber)

suspend fun upsert(article:Article)=db.getArticleDao().upsert(article)
fun getSavedNews()=db.getArticleDao().getALlArticles()
   suspend fun deleteArticle(article: Article)=db.getArticleDao().deleteArticle(article)


}