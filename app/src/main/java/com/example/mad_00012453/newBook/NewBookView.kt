package com.example.mad_00012453.newBook

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.mad_00012453.R

@Composable
fun NewBookView(viewModel: NewBookModel = NewBookModel()) {
    val context = LocalContext.current
    val title = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        TitleInput(title = title.value, onTitleChange = { title.value = it })
        Spacer(Modifier.height(16.dp))
        AuthorInput()
        Spacer(Modifier.height(16.dp))
        MainRolesInput()
        Spacer(Modifier.height(16.dp))
        PriceInput()
        Spacer(Modifier.height(16.dp))
        val validationMsg = stringResource(id = R.string.add_new_validation_msg)
        AddNewButton {
//            if (isInputValid(title.value)) //todo
//            viewModel.saveBook(null)
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}


@Composable
private fun TitleInput(title: String, onTitleChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = title,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onTitleChange(it) },
        label = {
            Text(stringResource(id = R.string.title_input))
        }
    )
}


@Composable
private fun AuthorInput() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = Color.LightGray),
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { text = it },
        label = {
            Text(stringResource(id = R.string.author_input))
        }
    )
}

@Composable
private fun MainRolesInput() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = Color.LightGray),
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { text = it },
        label = {
            Text(stringResource(id = R.string.main_roles_input))
        }
    )
}

@Composable
private fun PriceInput() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { text = it },
        label = {
            Text(stringResource(id = R.string.price_text))
        }
    )
}

@Composable
private fun AddNewButton(onClick: () -> Unit) {

    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.new_book_text)
        )
    }
}

//    private fun isInputValid(): Boolean {
//todo implement
//        if ()
//        return true
//    }
