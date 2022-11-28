package com.example.mad_00012453

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
import com.example.mad_00012453.addNew.AddNewViewModel
import com.example.mad_00012453.R

@Composable
fun AddNewView(viewModel: AddNewViewModel = AddNewViewModel()) {
    val context = LocalContext.current

    val name = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        NameInput(name = name.value, onNameChange = { name.value = it })
        Spacer(Modifier.height(16.dp))
        DescriptionInput()
        Spacer(Modifier.height(16.dp))
        ActorsInput()
        Spacer(Modifier.height(16.dp))
        BudgetInput()
        Spacer(Modifier.height(16.dp))
        AddNewButton {
//            if (isInputValid()) //todo
//            viewModel.saveNewMovieToRemoteDb(null)
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}


@Composable
private fun NameInput(name: String, onNameChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = name,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onNameChange(it) },
        label = {
            Text(stringResource(id = R.string.add_new_name_input_hint))
        }
    )
}


@Composable
private fun DescriptionInput() {
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
            Text(stringResource(id = R.string.add_new_description_input_hint))
        }
    )
}

@Composable
private fun ActorsInput() {
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
            Text(stringResource(id = R.string.add_new_actors_input_hint))
        }
    )
}

@Composable
private fun BudgetInput() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { text = it },
        label = {
            Text(stringResource(id = R.string.add_new_name_budget_hint))
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
            text = stringResource(id = R.string.add_new_save_button_text)
        )
    }
}

//    private fun isInputValid(): Boolean {
//todo implement
//        if ()
//        return true
//    }
