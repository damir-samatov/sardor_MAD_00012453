package com.example.mad_00012453.aboutBook

import androidx.lifecycle.ViewModel
import com.example.mad_00012453.models.Book

class AboutBookModel : ViewModel() {
    fun getBook(bookId: String): Book {
        return Book(
                "1",
                "Alfido",
                "Onur Qoplon",
                listOf("Zaynab", "Yusuf"),
                "25"
            )
    }
}