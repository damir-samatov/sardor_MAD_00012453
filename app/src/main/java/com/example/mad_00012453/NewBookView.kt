package com.example.mad_00012453

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mad_00012453.DB
import com.example.mad_00012453.R

@Composable
fun NewBookView(navController: NavController) {
    val title = remember { mutableStateOf("") }
    val author = remember { mutableStateOf("") }
    val roles = remember { mutableStateOf("") }
    val abstract = remember { mutableStateOf("") }
    val price = remember { mutableStateOf("") }
    val isValidated = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        TitleInput(title.value, { title.value = it })

        Spacer(Modifier.height(16.dp))

        AuthorInput(author.value, { author.value = it })

        Spacer(Modifier.height(16.dp))

        MainRolesInput(roles.value, { roles.value = it })

        Spacer(Modifier.height(16.dp))

        AbstractInput(abstract.value, { abstract.value = it })

        Spacer(Modifier.height(16.dp))

        PriceInput(price.value, { price.value = it })

        Spacer(Modifier.height(16.dp))

        if(!isValidated.value) {
            Text(text = "Please fill out all the fields")
        }

        AddNewButton {
            val isAdded = DB.addNewBook(
                title.value,
                author.value,
                price.value,
                roles.value,
                abstract.value
            )
            isValidated.value = isAdded
            if(isAdded){
                navController.navigate("booksList")
            }
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
private fun AuthorInput(author: String, onAuthorChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.LightGray),
        value = author,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onAuthorChange(it) },
        label = {
            Text(stringResource(id = R.string.author_input))
        }
    )
}

@Composable
private fun MainRolesInput(roles: String, onRoleChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.LightGray),
        value = roles,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onRoleChange(it) },
        label = {
            Text(stringResource(id = R.string.main_roles_input))
        }
    )
}

@Composable
private fun AbstractInput(abstract: String, onAbstractChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = Color.LightGray),
        value = abstract,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onAbstractChange(it) },
        label = {
            Text(stringResource(id = R.string.abstract_input_text))
        }
    )
}

@Composable
private fun PriceInput(price: String, onPriceChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = price,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { onPriceChange(it) },
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
