package com.example.mad_00012453.library

import androidx.lifecycle.ViewModel
import com.example.mad_00012453.models.Book

class LibraryModel : ViewModel() {
    fun getBooksList(): List<Book> {

        return listOf(
            Book(
                "1",
                "Alfido",
                "Onur Qoplon",
                listOf("Zaynab", "Yusuf"),
                "25"
            ),
            Book(
                "2",
                "Odam amfibiya",
                "Aleksandr Belyayev",
                listOf("Ixtiandr", "Salvator"),
                "16"
            ),
        )
    }
}