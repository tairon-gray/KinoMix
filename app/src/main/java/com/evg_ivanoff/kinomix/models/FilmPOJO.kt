package com.evg_ivanoff.kinomix

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//это мы получаем через api
data class FilmListItem(
    @SerializedName("Search"       ) var search       : ArrayList<FilmListItemDetail> = arrayListOf(),
    @SerializedName("totalResults" ) var totalResults : String?           = null,
    @SerializedName("Response"     ) var response     : String?           = null
)

//это используем для отображения результатов
data class FilmListItemDetail(
    @SerializedName("Title"  ) var title  : String? = null,
    @SerializedName("Year"   ) var year   : String? = null,
    @SerializedName("imdbID" ) var imdbID : String? = null,
    @SerializedName("Type"   ) var type   : String? = null,
    @SerializedName("Poster" ) var poster : String? = null
)

//а это детальная информация, связывается по imdbID
@Entity(tableName = "favorite_films_table")
data class Film(
    @SerializedName("Title")
    var title: String? = null,
    @SerializedName("Year")
    var year: String? = null,
    @SerializedName("Rated")
    var rated: String? = null,
    @SerializedName("Released")
    var released: String? = null,
    @SerializedName("Runtime")
    var runtime: String? = null,
    @SerializedName("Genre")
    var genre: String? = null,
    @SerializedName("Director")
    var director: String? = null,
    @SerializedName("Writer")
    var writer: String? = null,
    @SerializedName("Actors")
    var actors: String? = null,
    @SerializedName("Plot")
    var plot: String? = null,
    @SerializedName("Language")
    var language: String? = null,
    @SerializedName("Country")
    var country: String? = null,
    @SerializedName("Awards")
    var awards: String? = null,
    @SerializedName("Poster")
    var poster: String? = null,
    //Это я убрал просто чтобы не париться
//    @Embedded
//    @SerializedName("Ratings")
//    var ratings: ArrayList<Ratings> = arrayListOf(),
    @SerializedName("Metascore")
    var metascore: String? = null,
    @SerializedName("imdbRating")
    var imdbRating: String? = null,
    @SerializedName("imdbVotes")
    var imdbVotes: String? = null,
    @PrimaryKey
    @NonNull
    @SerializedName("imdbID")
    var imdbID: String,
    @SerializedName("Type")
    var type: String? = null,
    @SerializedName("DVD")
    var dvd: String? = null,
    @SerializedName("BoxOffice")
    var boxOffice: String? = null,
    @SerializedName("Production")
    var production: String? = null,
    @SerializedName("Website")
    var website: String? = null,
    @SerializedName("Response")
    var response: String? = null
)

//data class Ratings(
//    @SerializedName("Source") var source: String? = null,
//    @SerializedName("Value") var value: String? = null
//)
