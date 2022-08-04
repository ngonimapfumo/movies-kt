package zw.co.nm.movieskt.data.models

data class Movie (private var medium_cover_image: String, private val large_cover_image: String, private val title: String, private val year: String, private val language: String, private val genres: List<*>)