package com.example.mad_00012453

import com.example.mad_00012453.models.Book

object DB {
     private val booksLiveData = mutableListOf<Book>(
         Book(
             id = "1",
             title = "The Count of Monte Cristo",
             author = "A. Dumas",
             abstract = "Thrown in prison for a crime he has not committed, Edmond Dantès is confined to the grim fortress of If There he learns of a great hoard of treasure hidden on the Isle of Monte Cristo and he becomes determined not only to escape, but also to unearth the treasure and use it to plot the destruction of the three men responsible for his incarceration.",
             price = "30",
             mainRoles = listOf("Edmon Dantes - Prisoner", "Jocopo - Edmond's friend"),
         ),
         Book(
             id = "2",
             title = "Amphibian Man",
             author = "Alexander Romanovich Belyaev",
             abstract = "Argentinean doctor Salvator, a scientist and a maverick surgeon, gives his son, Ichthyander (Russian: Ихтиандр, Ikhtiandr) (Greek etymology: Fish + Man a life-saving transplant - a set of shark gills. The experiment is a success but it limits the young man's ability to interact with the world outside his ocean environment. He has to spend much of his time in water. Pedro Zurita, a local pearl gatherer, learns about Ichthyander and tries to exploit the boy's superhuman diving abilities.",
             price = "25",
             mainRoles = listOf("Ichthyander  -Amphibian Man", "Salvator - Doctor"),
         ),
     )

    fun getAllBooks(): List<Book> {
        return booksLiveData
    }

    fun getBookById(id: String): Book? {
        return booksLiveData.find { book -> book.id == id }
    }

    fun deleteBookById(id: String) {
        val book = booksLiveData.find { book -> book.id == id }

        if(book in booksLiveData) {
            booksLiveData.remove(book)
        }
    }

    fun addNewBook(title: String, author: String, price: String, roles: String, abstract: String): Boolean {
        if(
            title != ""
            && author != ""
            && price != ""
            && roles != ""
            && abstract != ""
        ) {
            val book = Book(
                id =  (0..9999).random().toString(),
                title = title,
                author = author,
                abstract = abstract,
                price = price,
                mainRoles = roles.split(",")
            )
            booksLiveData.add(book)
            return true
        } else {
            return false
        }

    }
}


