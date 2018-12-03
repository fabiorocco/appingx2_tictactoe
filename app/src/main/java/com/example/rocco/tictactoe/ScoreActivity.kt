package com.example.rocco.tictactoe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.score_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScoreActivity : AppCompatActivity() {
    val scoreList = arrayListOf<ObjectScore>()

    val baseURL = "http://www.onzeweb.net/api/"

    val jsonConverter = GsonConverterFactory.create(GsonBuilder().create())

    val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(jsonConverter)
        .build()

    val service: WebServiceInterface = retrofit.create(WebServiceInterface::class.java)
    val callback = object : Callback<List<ObjectScore>> {
        override fun onFailure(call: Call<List<ObjectScore>>?, t: Throwable?) {
            // Code here what happens if calling the WebService fails
            Log.d("TAG", "WebService call failed")
        }
        override fun onResponse(call: Call<List<ObjectScore>>?,
                                response: Response<List<ObjectScore>>?) {
            // Code here what happens when WebService responds
            if (response != null) {
                Log.d("TAG", response.toString())
                if (response.code() == 200) {
                    // We got our data !
                    val responseData = response.body()
                    if (responseData != null) {
                        scoreList.addAll(responseData)
                        list_score.adapter = ScoreObjectManager(scoreList)
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score_activity)

        service.listScore().enqueue(callback)
    }
}