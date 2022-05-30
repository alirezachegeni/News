package com.alireza.newsapp.di

import android.content.Context
import androidx.room.Room
import com.alireza.newsapp.database.ArticlesDao
import com.alireza.newsapp.database.ArticlesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Database
{
     @Singleton
     @Provides
     fun provideArticlesDatabase(
               @ApplicationContext context : Context
     ):ArticlesDatabase{
          return Room.databaseBuilder(
                    context,
                    ArticlesDatabase::class.java,
                    "articles.db"
          )
                    .fallbackToDestructiveMigration()
                    .build()
     }
     
     @Singleton
     @Provides
     fun provideArticlesDao(articlesDatabase : ArticlesDatabase):ArticlesDao = articlesDatabase.articlesDao()
}