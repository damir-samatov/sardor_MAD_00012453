package com.example.mad_00012453.detailedView

import androidx.lifecycle.ViewModel
import com.example.mad_00012453.Movie

class DetailedViewModel : ViewModel() {
    fun getMovieByIdFromRemoteDb(movieId: String): Movie {
        return Movie(
            "1",
                "Mad Max",
                "Guys killing each other in Australia",
                listOf("Tom Hardy", "Charliz Theron"),
                "350"
            )
    }
}