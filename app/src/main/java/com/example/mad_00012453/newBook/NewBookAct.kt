package com.example.mad_00012453.newBook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mad_00012453.newBook.NewBookView
import com.example.mad_00012453.ui.theme.MAD_00012453Theme




class NewBookAct : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MAD_00012453Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NewBookView()
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview3() {
        MAD_00012453Theme {
            NewBookView()
        }
    }
}