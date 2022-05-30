package com.alireza.newsapp.repository

import com.alireza.newsapp.database.ArticlesEntity
import com.alireza.newsapp.model.Articles
import com.alireza.newsapp.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
          private val localDatasource : LocalDatasource,
          private val remoteDatasource : RemoteDatasource
):Repository
{
     override fun topHeadline(country : String , category : String) : Flow<List<Articles>> = flow{
          emit(remoteDatasource.topHeadlines(country, category))
     }.flowOn(Dispatchers.IO)
     
     override fun searchNews(query : String , sortBy:String) : Flow<List<Articles>> = flow{
          emit(remoteDatasource.searchNews(query , sortBy))
     }.flowOn(Dispatchers.IO)
     
     override fun getAllNews() : Flow<List<Articles>>
     {
          return localDatasource.getAllNews()
     }
     
     override suspend fun addNews(articles : Articles)
     {
          localDatasource.insertNews(articles)
     }
     
     override suspend fun deleteNews(articlesEntity : ArticlesEntity)
     {
          localDatasource.deleteNews(articlesEntity)
     }
}