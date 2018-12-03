package com.example.rocco.tictactoe

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServiceInterface {
    @GET("scores.json")
    fun listScore(): Call<List<ObjectScore>>
}