package com.alireza.newsapp.ui.detail_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.alireza.newsapp.ui.common.WebView
import com.alireza.newsapp.util.navUnMaskUrl

@Composable
fun NewDetailScreen(
          url:String,
          navController : NavController
)
{
     val navUnMakUrl = navUnMaskUrl(url)
     
     Column {
          TopAppBar(
                    title = {
                         Text(text ="NewsApp")
                    },
                    navigationIcon = {
                         IconButton(onClick = { navController.navigateUp() }) {
                              Icon(imageVector = Icons.Default.ArrowBack ,
                                   contentDescription = "arrowBack")
                         }
                    },
                    backgroundColor = MaterialTheme.colors.primaryVariant
          )
          WebView(url = navUnMakUrl)
     }
}