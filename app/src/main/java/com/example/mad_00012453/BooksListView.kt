package com.example.mad_00012453

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mad_00012453.models.Book

@Composable
fun BooksListView(
    onBookClick: (String) -> Unit = {},
    navController: NavController
) {
    val books = DB.getAllBooks()

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .background(
                    colorResource(R.color.library_bg)
                )
                .padding(0.dp, 0.dp, 0.dp, 50.dp),
        ) {
            items(items = books, itemContent = { item ->
                BookItem(book = item, onBookClick)
            })
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(0.dp, 0.dp, 0.dp, 70.dp),
            onClick = { navController.navigate("newBook") })
        {
            Text(
                stringResource(id = R.string.new_book_label),
                modifier = Modifier.padding(15.dp, 5.dp),
                color = colorResource(id = R.color.new_book_text_color)
            )
        }
    }

}

@Composable
fun BookItem(book: Book, onBookClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 10.dp, 15.dp, 0.dp)
            .clickable {
                onBookClick(book.id)
            }
    ) {
        Title(title = book.title)
        Author(author = book.author)
        Divider(
            modifier = Modifier
                .padding(top = 10.dp)
                .background(Color.Gray)
        )
    }
}

@Composable
private fun Title(title: String) {
    Text(
        text = title,
        color = Color.Black,
        fontSize = 20.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Author(author: String) {
    Text(
        text = author,
        color = Color.DarkGray,
        fontSize = 16.sp,
        fontFamily = FontFamily.SansSerif
    )
}
