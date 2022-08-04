package zw.co.nm.movieskt.data.responses

data class Data(
    val movie_count: Int,
    val limit: Int,
    val page_number: Int,
    val movies: Array<Movie>

)