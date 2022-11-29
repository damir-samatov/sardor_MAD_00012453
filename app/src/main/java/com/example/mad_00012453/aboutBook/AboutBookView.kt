package com.example.mad_00012453.aboutBook


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.mad_00012453.R

@Composable
fun AboutBookView(bookId: String, viewModel: AboutBookModel = AboutBookModel()) {

    val book = viewModel.getBook(bookId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.about_book_bg))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            Title(title = book.title)
            Spacer(Modifier.weight(1f))
            Price(price = book.price)
        }
        Author(author = book.author)
        MyDivider()
        Spacer(Modifier.height(16.dp))
        MainRoles(mainRoles = book.mainRoles)
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
        text = stringResource(id = R.string.price_label, price),
        color = Color.Black,
        fontSize = 15.sp,
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