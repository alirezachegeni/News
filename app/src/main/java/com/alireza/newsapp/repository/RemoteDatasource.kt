package com.alireza.newsapp.repository

import com.alireza.newsapp.model.Articles
import com.alireza.newsapp.network.NewsApi
import com.alireza.newsapp.network.toDomainModel
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
          private val newsApi : NewsApi
)
{
     suspend fun topHeadlines(country:String , category:String):List<Articles>{
          return newsApi.topHeadlines(country, category).toDomainModel()
     }
     
     suspend fun searchNews(query:String , sortBy:String):List<Articles> {
          return newsApi.searchNews(query , sortBy).toDomainModel()
     }
}