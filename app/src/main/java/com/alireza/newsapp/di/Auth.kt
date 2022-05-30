package com.alireza.newsapp.di

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import com.alireza.newsapp.R

@Module
@InstallIn(ViewModelComponent::class)
object Auth
{
     @Provides
     fun provideGsoOption(
               @ApplicationContext context : Context ,
     ) : GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
               .requestIdToken(context.getString(R.string.client_id))
               .requestEmail()
               .build()
     
     @Provides
     fun provideGsoClient(
               @ApplicationContext context : Context ,
     ) : GoogleSignInClient = GoogleSignIn.getClient(context , provideGsoOption(context))
}