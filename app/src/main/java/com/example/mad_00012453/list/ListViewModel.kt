package com.example.mad_00012453

import androidx.lifecycle.ViewModel
import com.example.mad_00012453.Movie

class ListViewModel : ViewModel() {
    fun getListOfMoviesFromRemoteDb(): List<Movie> {

        return listOf(
            Movie(
                "1",
                "Mad Max",
                "Guys killing each other in Australia",
                listOf("Tom Hardy", "Charliz Theron"),
                "350"
            ),
            Movie(
                "2",
                "The Silence of the Lambs",
                "Pretty girl catching a bad guy",
                listOf("Jodie Foster", "Anthony Hopkins"),
                "19"
            ),
        )
    }
}