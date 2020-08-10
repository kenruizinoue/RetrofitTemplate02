package com.kenruizinoue.retrofittemplate2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val apiService by lazy { ServiceBuilder.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        beginFetch()
    }

    private fun beginFetch() {
        apiService.getMovies("ebe9b0dfaabd5a2f238db7c7109c6cb7")
                .enqueue(object : Callback<PopularMovies> {
                    override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                        if (response.isSuccessful)
                            textView.text = "Fetched in total: ${response.body()!!.results.size} movies"
                    }

                    override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
    }
}