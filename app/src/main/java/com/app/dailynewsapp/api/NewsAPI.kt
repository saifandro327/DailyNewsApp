package com.app.dailynewsapp.api

import com.app.dailynewsapp.models.NewsResponse
import com.app.dailynewsapp.util.Contants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun  getTopNews(
        @Query ("country")
        countrycode:String="us",
        @Query("page")
        pagenumber:Int=1,
        @Query("api_key")
        apikey:String=API_KEY):
Response<NewsResponse>


    @GET("v2/everything")
    suspend fun  searchNews(
        @Query ("country")
        countrycode:String="us",
        @Query("page")
        pagenumber:Int=1,
        @Query("api_key")
        apikey:String=API_KEY):
            Response<NewsResponse>
    }



