package com.app.dailynewsapp.repository

import com.app.dailynewsapp.api.RetrofitInstance
import com.app.dailynewsapp.db.ArticleDatabase

class NewsRepository (
    val db : ArticleDatabase
){
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int)=
            RetrofitInstance.api.getTopNews(countryCode,pageNumber)
}
suspend fun searchNews()