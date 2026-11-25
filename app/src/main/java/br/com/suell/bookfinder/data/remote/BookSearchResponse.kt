package br.com.suell.bookfinder.data.remote

import com.google.gson.annotations.SerializedName

data class BookSearchResponse(
    @SerializedName("docs")
    val books: List<BookResponse>
)

data class BookResponse(
    @SerializedName("key")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("author_name")
    val authors: List<String>?,

    @SerializedName("cover_i")
    val coverId: Int?,

    @SerializedName("first_publish_year")
    val firstPublishYear: Int?
)