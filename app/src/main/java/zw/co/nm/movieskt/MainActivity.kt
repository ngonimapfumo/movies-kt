package zw.co.nm.movieskt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import zw.co.nm.movieskt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.textView.text = "Holla"
    }

    fun test() {


    }
}