package zw.co.nm.movieskt

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import zw.co.nm.movieskt.api.Retrofit
import zw.co.nm.movieskt.data.responses.GetMovie
import zw.co.nm.movieskt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        test()

    }

    private fun test() {
        val call = Retrofit.getService()?.getMovies()
        call?.enqueue(object: Callback<GetMovie?>{
            override fun onResponse(call: Call<GetMovie?>, response: Response<GetMovie?>) {
               // activityMainBinding.textView.text = response.body()?.data?.movies?.get(1)?.synopsis.toString()
            }

            override fun onFailure(call: Call<GetMovie?>, t: Throwable) {
                activityMainBinding.textView.text = t.localizedMessage
            }

        })
    }
}