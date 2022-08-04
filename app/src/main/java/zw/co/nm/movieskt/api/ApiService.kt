package zw.co.nm.movieskt.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import zw.co.nm.movieskt.data.responses.GetMovie

interface ApiService {

    @GET("list_movies.json")
    fun getMovies(): Call<GetMovie>
}