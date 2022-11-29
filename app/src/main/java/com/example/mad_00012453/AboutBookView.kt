package com.example.mad_00012453

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnrememberedMutableState")
@Composable
fun AboutBookView(bookId: String, navController: NavController) {

    val book = DB.getBookById(bookId)
    val isOpen = remember {mutableStateOf(false)}

    if(book != null) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.about_book_bg))
                    .padding(16.dp)
            ) {
                Title(title = book.title)

                Spacer(Modifier.height(16.dp))

                Price(price = book.price)

                Author(author = book.author)

                MyDivider()

                Spacer(Modifier.height(16.dp))

                MainRoles(mainRoles = book.mainRoles)

                Spacer(Modifier.height(16.dp))

                if(isOpen.value) {
                    Abstract(text = book.abstract)
                }
                
                Button(onClick = { isOpen.value = !isOpen.value }) {
                    Text(
                        text = if(isOpen.value) "View less" else "View more"
                    )
                }

            }

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(0.dp, 0.dp, 0.dp, 70.dp),
                onClick = {
                    DB.deleteBookById(bookId)
                    navController.navigate("booksList")
                })
            {
                Text(
                    text = stringResource(id = R.string.delete_book_text),
                    modifier = Modifier.padding(15.dp, 5.dp),
                    color = colorResource(id = R.color.new_book_text_color)
                )
            }
        }
    }

}

@Composable
private fun Title(title: String) {
    Text(
        text = title,
        color = Color.Black,
        fontSize = 30.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Price(price: String) {
    Text(
        modifier = Modifier.padding(bottom = 3.dp),
        text = "$" + price,
        color = Color.Black,
        fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
private fun Author(author: String) {
    Text(
        modifier = Modifier.padding(top = 10.dp),
        text = author,
        color = Color.DarkGray,
        fontSize = 22.sp,
        fontFamily = FontFamily.SansSerif
    )
}


@Composable
private fun MainRoles(mainRoles: List<String>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        var i = 0
        for (mainRole in mainRoles) {
            ActorTextView(mainRole = mainRole, ++i == mainRoles.size)
        }
    }
}

@Composable
private fun Abstract(text: String) {
    Text(
        modifier = Modifier.padding(top = 10.dp),
        text = text,
        color = Color.DarkGray,
        fontSize = 22.sp,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
private fun ActorTextView(mainRole: String, isTheLastOne: Boolean) {
    Text(
        modifier = Modifier.padding(6.dp, 3.dp),
        text = if (isTheLastOne) mainRole else "$mainRole,",
        color = Color.DarkGray,
        fontSize = 19.sp,
        fontFamily = FontFamily.SansSerif,
        fontStyle = FontStyle.Italic
    )
}


@Composable
private fun MyDivider() {
    Divider(
        color = Color.LightGray
    )
}