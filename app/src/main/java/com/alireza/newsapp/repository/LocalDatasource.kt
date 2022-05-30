package com.alireza.newsapp.repository

import com.alireza.newsapp.database.ArticlesDao
import com.alireza.newsapp.database.ArticlesEntity
import com.alireza.newsapp.database.toDaoModel
import com.alireza.newsapp.database.toDomainModel
import com.alireza.newsapp.model.Articles
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDatasource @Inject constructor(
          private val articlesDao : ArticlesDao
)
{
     fun getAllNews():Flow<List<Articles>> = articlesDao.getAllNews().map { it.map { it.toDomainModel() } }
     
     suspend fun insertNews(articles : Articles) = articlesDao.insertNews(articles.toDaoModel())
     
     suspend fun deleteNews(articlesEntity : ArticlesEntity) = articlesDao.deleteNews(articlesEntity)
}